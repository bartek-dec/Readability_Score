package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TextAnalyzerTest {

    private final String text = "This is simple text with one polysyllable.";
    private final String stats = "Words: 7\nSentences: 1\nCharacters: 36\nSyllables: 10\nPolysyllables: 1\n";
    private final String index = "\nAutomated Readability Index: 7.25 (about 13 year olds).";

    @Mock
    private TextReader textReader;

    @Mock
    private Formatter formatter;

    private TextAnalyzer textAnalyzer;

    @BeforeEach
    void setUp() {
        textReader = Mockito.mock(TextReader.class);
        formatter = Mockito.mock(Formatter.class);

        textAnalyzer = new TextAnalyzer(textReader, formatter);
    }

    @Test
    void getStatistics() {
        when(formatter.getTextStatistics()).thenReturn(stats);

        String result = "Words: 7\nSentences: 1\nCharacters: 36\nSyllables: 10\nPolysyllables: 1\n";
        assertEquals(result, textAnalyzer.getTextStatistics());
    }

    @Test
    void getARI_Index() {
        when(formatter.getTextIndexes("ari")).thenReturn(index);

        String result = "\nAutomated Readability Index: 7.25 (about 13 year olds).";
        assertEquals(result, textAnalyzer.getIndexes("ari"));
    }

    @Test
    void countWords() {
        when(textReader.getText()).thenReturn(text);

        textAnalyzer.analyzeText();

        assertEquals(7, textAnalyzer.getScore().getWords());
    }

    @Test
    void whenNoFileThenZeroWords() {
        when(textReader.getText()).thenReturn(null);

        textAnalyzer.analyzeText();

        assertEquals(0, textAnalyzer.getScore().getWords());
    }

    @Test
    void whenNoTextThenZeroWords() {
        when(textReader.getText()).thenReturn("");

        textAnalyzer.analyzeText();

        assertEquals(0, textAnalyzer.getScore().getWords());
    }

    @Test
    void countSentences() {
        when(textReader.getText()).thenReturn(text);

        textAnalyzer.analyzeText();

        assertEquals(1, textAnalyzer.getScore().getSentences());
    }

    @Test
    void whenNoFileThenZeroSentences() {
        when(textReader.getText()).thenReturn(null);

        textAnalyzer.analyzeText();

        assertEquals(0, textAnalyzer.getScore().getSentences());
    }

    @Test
    void whenNoTextThenZeroSentences() {
        when(textReader.getText()).thenReturn("");

        textAnalyzer.analyzeText();

        assertEquals(0, textAnalyzer.getScore().getSentences());
    }

    @Test
    void countCharacters() {
        when(textReader.getText()).thenReturn(text);

        textAnalyzer.analyzeText();

        assertEquals(36, textAnalyzer.getScore().getCharacters());
    }

    @Test
    void whenNoFileThenZeroCharacters() {
        when(textReader.getText()).thenReturn(null);

        textAnalyzer.analyzeText();

        assertEquals(0, textAnalyzer.getScore().getCharacters());
    }

    @Test
    void whenNoTextThenZeroCharacters() {
        when(textReader.getText()).thenReturn("");

        textAnalyzer.analyzeText();

        assertEquals(0, textAnalyzer.getScore().getCharacters());
    }

    @Test
    void countSyllables() {
        when(textReader.getText()).thenReturn(text);

        textAnalyzer.analyzeText();

        assertEquals(10, textAnalyzer.getScore().getSyllables());
    }

    @Test
    void whenNoFileThenZeroSyllables() {
        when(textReader.getText()).thenReturn(null);

        textAnalyzer.analyzeText();

        assertEquals(0, textAnalyzer.getScore().getSyllables());
    }

    @Test
    void whenNoTextThenZeroSyllables() {
        when(textReader.getText()).thenReturn("");

        textAnalyzer.analyzeText();

        assertEquals(0, textAnalyzer.getScore().getSyllables());
    }

    @Test
    void countPolySyllables() {
        when(textReader.getText()).thenReturn(text);

        textAnalyzer.analyzeText();

        assertEquals(1, textAnalyzer.getScore().getPolysyllables());
    }

    @Test
    void whenNoFileThenZeroPolySyllables() {
        when(textReader.getText()).thenReturn(null);

        textAnalyzer.analyzeText();

        assertEquals(0, textAnalyzer.getScore().getPolysyllables());
    }

    @Test
    void whenNoTextThenZeroPolySyllables() {
        when(textReader.getText()).thenReturn("");

        textAnalyzer.analyzeText();

        assertEquals(0, textAnalyzer.getScore().getPolysyllables());
    }
}