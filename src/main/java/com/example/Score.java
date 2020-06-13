package com.example;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private double words;
    private double sentences;
    private double characters;
    private double syllables;
    private double polysyllables;
    private double indexAutomatedReadability;
    private double indexFleschKincaid;
    private double indexSMOG;
    private double indexColemanLiau;
    private double averageAge;
    private Map<String, Double> ages = new HashMap<>();

    public Score() {
    }

    public double getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public double getSentences() {
        return sentences;
    }

    public void setSentences(int sentences) {
        this.sentences = sentences;
    }

    public double getCharacters() {
        return characters;
    }

    public void setCharacters(int characters) {
        this.characters = characters;
    }

    public double getIndexAutomatedReadability() {
        countIndexAutomatedReadability();
        return indexAutomatedReadability;
    }

    public double getSyllables() {
        return syllables;
    }

    public void setSyllables(int syllables) {
        this.syllables = syllables;
    }

    public double getPolysyllables() {
        return polysyllables;
    }

    public void setPolysyllables(int polysyllables) {
        this.polysyllables = polysyllables;
    }

    public double getIndexFleschKincaid() {
        countIndexFleschKincaid();
        return indexFleschKincaid;
    }

    public double getIndexSMOG() {
        countIndexSMOG();
        return indexSMOG;
    }

    public double getIndexColemanLiau() {
        calculateIndexColemanLiau();
        return indexColemanLiau;
    }

    public double getAverageAge() {
        calculateAverageAge();
        return averageAge;
    }

    public Map<String, Double> getAges() {
        return ages;
    }

    private void calculateAverageAge() {
        averageAge = ages.entrySet().stream()
                .mapToDouble(entry -> entry.getValue())
                .average()
                .getAsDouble();
    }

    private void calculateIndexColemanLiau() {
        double factor1 = 0.0588;
        double factor2 = 0.296;
        double factor3 = 15.8;
        double L = (characters / words) * 100.0;
        double S = (sentences / words) * 100;
        double result = factor1 * L - factor2 * S - factor3;

        indexColemanLiau = Double.isNaN(result) ? -1.0 : result;
    }

    private void countIndexSMOG() {
        double factor1 = 1.043;
        double factor2 = 30;
        double factor3 = 3.1291;
        double result = factor1 * Math.sqrt(polysyllables * (factor2 / sentences)) + factor3;

        indexSMOG = Double.isNaN(result) ? -1.0 : result;
    }

    private void countIndexFleschKincaid() {
        double factor1 = 0.39;
        double factor2 = 11.8;
        double factor3 = 15.59;
        double result = factor1 * (words / sentences) + factor2 * (syllables / words) - factor3;

        indexFleschKincaid = Double.isNaN(result) ? -1.0 : result;
    }

    private void countIndexAutomatedReadability() {
        double factor1 = 4.71;
        double factor2 = 0.5;
        double factor3 = 21.43;

        double result = factor1 * (characters / words) + factor2 * (words / sentences) - factor3;

        indexAutomatedReadability = Double.isNaN(result) ? -1.0 : result;
    }
}
