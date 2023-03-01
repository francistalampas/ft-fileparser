package com.ft.fileparser.filestats;

public class CharStatsHelper {
    private static final String LABEL_CHARACTER_NUMBER = "(%c) count: ";

    /**
     * Get the number of occurrences of the specified character
     * @param checkCharacter
     * @param fileContents
     * @return long
     */
    public static long getCharacterCount(Character checkCharacter, String fileContents) {
        return fileContents.chars().filter(ch -> ch == checkCharacter).count();
    }

    /**
     * Formats the label for displaying character occurrences count
     * @param checkCharacter
     * @return String
     */
    public static String getCharacterCountLabel(Character checkCharacter){
        return String.format(LABEL_CHARACTER_NUMBER, checkCharacter);
    }
}
