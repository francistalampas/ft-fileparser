package com.ft.fileparser.filereader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.nio.file.Path;

public class PDFFileReader implements FileReader {
    @Override
    public String readFile(Path filePath) throws IOException {
        PDDocument document = PDDocument.load(filePath.toFile());
        PDFTextStripper stripper = new PDFTextStripper();
        String fileText = stripper.getText(document);
        document.close();
        return fileText;
    }
}
