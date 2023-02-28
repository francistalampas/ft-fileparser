package com.ft.fileparser.filereader;

import java.io.IOException;
import java.nio.file.Path;

public interface FileReader {
    String readFile(Path filePath) throws IOException;
}
