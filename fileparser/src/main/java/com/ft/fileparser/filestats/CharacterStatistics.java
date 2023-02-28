package com.ft.fileparser.filestats;

public class CharacterStatistics {

    private static final String LABEL_CHARACTER_NUMBER = "(%c) count: ";
    private static final char CHARACTER_DOT = '.';

    public static void print(String fileContents) {
        System.out.println(getCharacterCount(CHARACTER_DOT, fileContents));
    }

    private static String getCharacterCount(Character checkCharacter, String fileContents) {
        return String.format(LABEL_CHARACTER_NUMBER, checkCharacter)
                + fileContents.chars().filter(ch -> ch == checkCharacter).count();
    }
}
