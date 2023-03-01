package com.ft.fileparser.filereader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TextFileReaderTests {

    private static final String EXPECTED_FILE_CONTENT =
            "This file will be used to test a coding test. This is a sample test file.";

    private static final String FILE_PATH =
            "/Users/francistalampas/fileparser/src/test/resources/text-file.txt";

    @Test
    public void givenTextFile_CheckIfReadSuccessfully() throws IOException {
        TextFileReader textFileReader = new TextFileReader();
        Assertions.assertEquals(EXPECTED_FILE_CONTENT,
                textFileReader.readFile(Path.of(FILE_PATH)));
    }
}
