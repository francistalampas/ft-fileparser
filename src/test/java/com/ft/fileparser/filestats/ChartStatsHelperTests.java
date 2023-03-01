package com.ft.fileparser.filestats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChartStatsHelperTests {
    private static final String FILE_CONTENT =
            "This file will be used in a coding test. This is a sample test file.";
    private static final char CHARACTER_DOT = '.';

    private static final long EXPECTED_COUNT_CHARACTER = 2;

    private static final String EXPECTED_LABEL_CHARACTER_COUNT = "(.) count: ";

    @Test
    public void givenFileContentAndCharacter_CheckIfCorrectCharacterCount(){
        Assertions.assertEquals(EXPECTED_COUNT_CHARACTER,
                CharStatsHelper.getCharacterCount(CHARACTER_DOT, FILE_CONTENT));
    }

    @Test
    public void givenCharacter_CheckIfCorrectCharacterCountLabel(){
        Assertions.assertEquals(EXPECTED_LABEL_CHARACTER_COUNT,
                CharStatsHelper.getCharacterCountLabel(CHARACTER_DOT));
    }
}
