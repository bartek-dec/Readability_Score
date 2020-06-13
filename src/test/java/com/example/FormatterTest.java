package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FormatterTest {

    private final String stats = "Words: 7\nSentences: 1\nCharacters: 36\nSyllables: 10\nPolysyllables: 1\n";
    private final String index = "\nAutomated Readability Index: 7.25 (about 13 year olds).";

    @Mock
    private Score score;

    private Formatter formatter;

    @BeforeEach
    void setUp() {
        score = Mockito.mock(Score.class);
        formatter = new Formatter();
        formatter.setScore(score);
    }

    @Test
    void getTextStatistics() {
        when(score.getWords()).thenReturn(7.0);
        when(score.getSentences()).thenReturn(1.0);
        when(score.getCharacters()).thenReturn(36.0);
        when(score.getSyllables()).thenReturn(10.0);
        when(score.getPolysyllables()).thenReturn(1.0);

        assertEquals(stats, formatter.getTextStatistics());
    }

    @Test
    void getTextIndexes() {
        when(score.getIndexAutomatedReadability()).thenReturn(7.25);

        assertEquals(index, formatter.getTextIndexes("ari"));
    }
}