package com.ft.fileparser;

import com.ft.fileparser.filereader.FileReaderRegistry;
import com.ft.fileparser.filestats.ChartStats;
import com.ft.fileparser.filestats.WordStats;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileParser {
    private static final String PROCESSED = "processed";

    @Autowired
    WordStats wordStats;

    @Autowired
    ChartStats charStats;

    /**
     * Provides statistics for the supported files from the provided directory every 5 seconds
     * @param directoryPath
     * @throws IOException
     * @throws InterruptedException
     */
    public void parseFilesMonitorMode(String directoryPath) throws IOException, InterruptedException {
        while(true){
            parseFiles(directoryPath);
            System.out.println(System.currentTimeMillis());
            Thread.sleep(5000);
        }
    }

    /**
     * Provides statistics for the supported files from the provided directory
     * @param directoryPath working directory of the files
     * @throws IOException
     */
    public void parseFiles(String directoryPath) throws IOException {
        Path processedFullPath = Path.of(directoryPath, PROCESSED);
        File processedFolder = new File(processedFullPath.toString());
        if(!processedFolder.isDirectory()){
            processedFolder.mkdirs();
        }

        try (Stream<Path> paths = Files.list(Paths.get(directoryPath))) {
            List<Path> filePaths = paths.filter(Files::isRegularFile).collect(Collectors.toList());
            for(Path filePath : filePaths){
                String fileName = filePath.getFileName().toString();
                String fileExtension = FilenameUtils.getExtension(fileName);
                if(FileReaderRegistry.isFileSupported(fileExtension)){
                    String fileContents = FileReaderRegistry.getFileReader(fileExtension).readFile(filePath);
                    printStatistics(fileName, fileContents);
                    Files.move(filePath, Path.of(processedFullPath + File.separator + fileName));
                }
            }
        }
    }

    /**
     * Defines the report of the file statistics
     * @param fileName
     * @param fileContents
     */
    private void printStatistics(String fileName, String fileContents){
        System.out.print(System.lineSeparator());
        System.out.println(fileName);
        wordStats.print(fileContents);
        charStats.print(fileContents);
    }
}
