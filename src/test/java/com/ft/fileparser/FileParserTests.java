package com.ft.fileparser;

import com.ft.fileparser.filestats.ChartStats;
import com.ft.fileparser.filestats.WordStats;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileParserTests {
    private static final String DIRECTORY_PATH = "/Users/francistalampas/fileparser/src/test/resources";
    private static final String PROCESSED = "processed";
    private static final String PDF_FILE = "pdf-file.pdf";
    private static final String TEXT_FILE = "text-file.txt";
    @Test
    public void givenDirectory_CheckIfFilesParsed() throws IOException, InterruptedException {
        FileParser fileParser = new FileParser();
        fileParser.wordStats = new WordStats();
        fileParser.charStats = new ChartStats();
        fileParser.parseFiles(DIRECTORY_PATH);
        Path processedFullPath = Path.of(DIRECTORY_PATH, PROCESSED);
        Assertions.assertTrue(Files.exists(Path.of(processedFullPath + File.separator + PDF_FILE)));
        Assertions.assertTrue(Files.exists(Path.of(processedFullPath + File.separator + TEXT_FILE)));
    }
}
