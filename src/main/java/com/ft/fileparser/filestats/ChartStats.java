package com.ft.fileparser.filestats;

import org.springframework.stereotype.Service;

@Service
public class ChartStats implements Stats {
    /**
     * Prints the implementations of the Character Statistics
     * 1. Dot Count (.)
     * @param fileContents
     */
    public void print(String fileContents) {
        System.out.println(CharStatsImpl.printDotCount(fileContents));
    }

}
