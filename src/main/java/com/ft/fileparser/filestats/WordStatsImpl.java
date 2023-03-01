package com.ft.fileparser.filestats;

public class WordStatsImpl {
    private static final String LABEL_WORD_NUMBER = "Word count: ";
    private static final String LABEL_MOST_USED_WORDS = "Most used words: ";

    /**
     * Prints the number of words
     * @param fileContents
     * @return String
     */
    public static String printWordCount(String fileContents){
        return LABEL_WORD_NUMBER + WordStatsHelper.getWordCount(fileContents);
    }

    /**
     * Prints the lists of most used words used
     * @param fileContents
     * @return String
     */
    public static String printMostUsedWords(String fileContents){
        return LABEL_MOST_USED_WORDS + WordStatsHelper.getMostUsedWords(fileContents);
    }
}
