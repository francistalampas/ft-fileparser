package com.ft.fileparser.filestats;

public class CharStatsImpl {
    private static final char CHARACTER_DOT = '.';

    /**
     * Prints the number of dots (.) from the provided String
     * @param fileContents
     * @return String
     */
    public static String printDotCount(String fileContents) {
        return CharStatsHelper.getCharacterCountLabel(CHARACTER_DOT)
                + CharStatsHelper.getCharacterCount(CHARACTER_DOT, fileContents);
    }
}
