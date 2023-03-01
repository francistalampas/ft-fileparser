package com.ft.fileparser.filestats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WordStatsHelperTests {
    private static final String FILE_CONTENT_001 =
            "Stop, Look and Listen! This test file will be used in a coding test...";
    private static final List<String> WORD_LIST_001 = Arrays.asList("test");
    private static final long EXPECTED_WORD_COUNT_001 = 14;

    private static final String FILE_CONTENT_002 =
            "Stop, Look and Listen! Look to stop and listen.";
    private static final List<String> WORD_LIST_002 = Arrays.asList("stop", "look", "and", "listen");

    @Test
    public void givenFileContent_CheckIfCorrectWordCount(){
        Assertions.assertEquals(EXPECTED_WORD_COUNT_001,
                WordStatsHelper.getWordCount(FILE_CONTENT_001));
    }

    @Test
    public void givenFileContent_CheckIfCorrectMostUsedWords(){
        List<String> expectedWordList = WORD_LIST_001;
        List<String> actualWordList = WordStatsHelper.getMostUsedWords(FILE_CONTENT_001);
        Assertions.assertTrue(
                expectedWordList.size() == actualWordList.size()
                        && expectedWordList.containsAll(actualWordList)
                        && actualWordList.containsAll(expectedWordList));
    }

    @Test
    public void givenFileContent_CheckIfCorrectMultipleMostUsedWords(){
        List<String> expectedWordList = WORD_LIST_002;
        List<String> actualWordList = WordStatsHelper.getMostUsedWords(FILE_CONTENT_002);
        Assertions.assertTrue(
                expectedWordList.size() == actualWordList.size()
                        && expectedWordList.containsAll(actualWordList)
                        && actualWordList.containsAll(expectedWordList));
    }

}
