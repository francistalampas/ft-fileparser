package com.ft.fileparser.filestats;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordStatistics {

    private static final String REGEX_PUNCTUATION = "\\p{Punct}";
    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final String LABEL_WORD_NUMBER = "Word count: ";
    private static final String LABEL_MOST_USED_WORDS = "Most used words: ";

    public static void print(String fileContents) {
        String[] words = getWords(fileContents);
        System.out.println(getWordCount(words));
        System.out.println(getMostUsedWords(words));
    }

    private static String[] getWords(String fileContents){
        String[] words = fileContents.replaceAll(REGEX_PUNCTUATION, BLANK)
                .toLowerCase().trim().split(SPACE);
        return words;
    }

    private static String getWordCount(String[] words){
        return LABEL_WORD_NUMBER + words.length;
    }

    private static String getMostUsedWords(String[] words){
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            if (wordsMap.containsKey(word))
                wordsMap.put(word, wordsMap.get(word) + 1);
            else
                wordsMap.put(word, 1);
        }
        int max = Collections.max(wordsMap.values());
        return LABEL_MOST_USED_WORDS +
                wordsMap.entrySet().stream()
                        .filter(entry -> entry.getValue() == max)
                        .map(entry -> entry.getKey())
                        .collect(Collectors.toList());
    }
}
