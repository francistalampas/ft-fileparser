package com.ft.fileparser.filereader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

public class PDFFileReaderTests {
    private static final String EXPECTED_FILE_CONTENT =
            "This is a sample test file. This file will be used to test a coding test.";

    private static final String FILE_PATH =
            "/Users/francistalampas/fileparser/src/test/resources/pdf-file.pdf";

    @Test
    public void givenPDFFile_CheckIfReadSuccessfully() throws IOException {
        PDFFileReader pdfFileReader = new PDFFileReader();
        Assertions.assertEquals(EXPECTED_FILE_CONTENT,
                pdfFileReader.readFile(Path.of(FILE_PATH)).trim());
    }
}
