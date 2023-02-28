package com.ft.fileparser.filereader;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FileReaderRegistry {
    private static final String TXT = "txt";
    private static final String PDF = "pdf";
    private static final Map<String, FileReader> fileReaderMap;
    static {
        Map<String, FileReader> fMap = new HashMap<>();
        fMap.put(TXT, new TextFileReader());
        fMap.put(PDF, new PDFFileReader());
        fileReaderMap = Collections.unmodifiableMap(fMap);
    }

    public static FileReader getFileReader(String fileExtension){
        return fileReaderMap.get(fileExtension);
    }

    public static boolean isFileSupported(String fileExtension){
        return fileReaderMap.containsKey(fileExtension);
    }

}
