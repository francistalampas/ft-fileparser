package com.ft.fileparser.filestats;

import org.springframework.stereotype.Service;

@Service
public class WordStats implements Stats {
    /**
     * Prints the implementations of the Word Statistics
     * 1. Number of Words
     * 2. Most Used Words
     * @param fileContents
     */
    public void print(String fileContents) {
        System.out.println(WordStatsImpl.printWordCount(fileContents));
        System.out.println(WordStatsImpl.printMostUsedWords(fileContents));
    }

}
