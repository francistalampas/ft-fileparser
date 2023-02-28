package com.ft.fileparser.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextFileReader implements FileReader {
    @Override
    public String readFile(Path filePath) throws IOException {
        return Files.readString(filePath);
    }
}
