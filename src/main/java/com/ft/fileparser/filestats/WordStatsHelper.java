package com.ft.fileparser.filestats;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordStatsHelper {
    private static final String REGEX_PUNCTUATION = "\\p{Punct}";
    private static final String BLANK = "";
    private static final String SPACE = " ";

    /**
     * Get the total number of words
     * @param fileContents
     * @return int
     */
    public static int getWordCount(String fileContents){
        return getWords(fileContents).length;
    }

    /**
     * Get the most used word/s
     * @param fileContents
     * @return List<String>
     */
    public static List<String> getMostUsedWords(String fileContents){
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : getWords(fileContents)) {
            if (wordsMap.containsKey(word))
                wordsMap.put(word, wordsMap.get(word) + 1);
            else
                wordsMap.put(word, 1);
        }
        int max = Collections.max(wordsMap.values());
        return wordsMap.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    /**
     * Get the words by removing punctuations and white spaces
     * @param fileContents
     * @return String[]
     */
    private static String[] getWords(String fileContents){
        String[] words = fileContents.replaceAll(REGEX_PUNCTUATION, BLANK)
                .toLowerCase().trim().split(SPACE);
        return words;
    }
}
