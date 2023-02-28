package com.ft.fileparser;

import com.ft.fileparser.filereader.FileReaderRegistry;
import com.ft.fileparser.filestats.CharacterStatistics;
import com.ft.fileparser.filestats.WordStatistics;
import org.apache.commons.io.FilenameUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class FileParserApplication implements CommandLineRunner {

	private static final String DIRECTORY_PATH = "/Users/francistalampas/fileparser/src/test/resources";
	private static final String PROCESSED = "processed";

	public static void main(String[] args) {
		SpringApplication.run(FileParserApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException {
		Path processedFullPath = Path.of(DIRECTORY_PATH, PROCESSED);
		File processedFolder = new File(processedFullPath.toString());
		if(!processedFolder.isDirectory()){
			processedFolder.mkdirs();
		}

		try (Stream<Path> paths = Files.list(Paths.get(DIRECTORY_PATH))) {
			List<Path> filePaths = paths.filter(Files::isRegularFile).collect(Collectors.toList());
			for(Path filePath : filePaths){
				String fileName = filePath.getFileName().toString();
				String fileExtension = FilenameUtils.getExtension(fileName);
				if(FileReaderRegistry.isFileSupported(fileExtension)){
					String fileContents = FileReaderRegistry.getFileReader(fileExtension).readFile(filePath);
					System.out.print(System.lineSeparator());
					System.out.println(fileName);

					WordStatistics.print(fileContents);
					CharacterStatistics.print(fileContents);

					Files.move(filePath, Path.of(processedFullPath + File.separator + fileName));
				}
			}
		}
	}


}
