package com.ft.fileparser.filereader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileReaderRegistryTests {

    private static final String EXTENSION_TEXT = "txt";
    private static final String CLASS_NAME_TEXTFILEREADER = "TextFileReader";

    private static final String EXTENSION_PDF = "pdf";
    private static final String CLASS_NAME_PDFFILEREADER = "PDFFileReader";

    @Test
    public void givenTextFileExtensionCheckIfTextFileReaderClass(){
        Assertions.assertEquals(CLASS_NAME_TEXTFILEREADER,
                FileReaderRegistry.getFileReader(EXTENSION_TEXT).getClass().getSimpleName());
    }

    @Test
    public void givenPDFFileExtensionCheckIfPDFFileReaderClass(){
        Assertions.assertEquals(CLASS_NAME_PDFFILEREADER,
                FileReaderRegistry.getFileReader(EXTENSION_PDF).getClass().getSimpleName());
    }
}
