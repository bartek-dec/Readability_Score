package com.example;

import java.util.Arrays;
import java.util.Objects;

public class TextAnalyzer {

    private TextReader reader;
    private Formatter formatter;
    private Score score;

    public TextAnalyzer(TextReader reader, Formatter formatter) {
        this.reader = reader;
        this.formatter = formatter;
        this.score = new Score();
    }

    public Score getScore() {
        return score;
    }

    public void analyzeText() {
        String text = reader.getText();

        score.setWords(countWords(text));
        score.setSentences(countSentences(text));
        score.setCharacters(countCharacters(text));
        countSyllables(text);

        formatter.setScore(score);
    }

    public String getTextStatistics() {
        return formatter.getTextStatistics();
    }

    public String getIndexes(String s) {
        return formatter.getTextIndexes(s);
    }

    private int countCharacters(String s) {
        if (Objects.equals(s, null)) {
            return 0;
        }

        if (Objects.equals(s, "")) {
            return 0;
        }

        return (int) Arrays.stream(s.split("")).filter(e -> e.matches("[^\\s]")).count();
    }

    private int countSentences(String s) {
        if (Objects.equals(s, null)) {
            return 0;
        }

        if (Objects.equals(s, "")) {
            return 0;
        }

        return (int) Arrays.stream(s.split("[.!?]")).count();
    }

    private int countWords(String s) {
        if (Objects.equals(s, null)) {
            return 0;
        }

        if (Objects.equals(s, "")) {
            return 0;
        }

        return (int) Arrays.stream(s.split("([,.;:!?]*\\s+|\\.)")).count();
    }

    private void countSyllables(String s) {
        if (Objects.equals(s, null)) {
            score.setSyllables(0);
            score.setPolysyllables(0);
        } else if (Objects.equals(s, "")) {
            score.setSyllables(0);
            score.setPolysyllables(0);
        } else {
            String[] words = s.toLowerCase().split("([,.;:!?]*\\s+|\\.)");
            int syllables = 0;
            int polySyllables = 0;

            for (String string : words) {
                int vowels = 0;

                String[] letters = string.split("");
                int length = letters.length;
                for (int i = 0; i < length; i++) {

                    if (letters[i].matches("[aeiouy]")) {
                        if (i < length - 1) {
                            if (letters[i + 1].matches("[aeiouy]")) {//two vowels next to each other
                                vowels++;
                                i++;
                            } else {
                                vowels++;
                            }
                        } else if (letters[i].matches("[e]")) {
                            continue;
                        } else {
                            vowels++;
                        }
                    }
                }

                if (vowels == 0 || vowels == length - 1) {
                    syllables++;
                } else {
                    syllables += vowels;
                }

                if (vowels >= 3) {
                    polySyllables++;
                }
            }
            score.setSyllables(syllables);
            score.setPolysyllables(polySyllables);
        }
    }
}
