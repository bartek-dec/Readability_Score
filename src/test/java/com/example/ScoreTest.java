package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScoreTest {

    private Score scoreWithInputs;
    private Score scoreWithOutInputs;

    @BeforeEach
    void setUp() {
        scoreWithInputs = new Score();
        scoreWithInputs.setWords(7);
        scoreWithInputs.setSentences(1);
        scoreWithInputs.setCharacters(36);
        scoreWithInputs.setSyllables(10);
        scoreWithInputs.setPolysyllables(1);

        scoreWithInputs.getAges().put("12", 12.0);
        scoreWithInputs.getAges().put("10", 10.0);
        scoreWithInputs.getAges().put("15", 15.0);
        scoreWithInputs.getAges().put("16", 16.0);

        scoreWithOutInputs = new Score();
        scoreWithOutInputs.setWords(0);
        scoreWithOutInputs.setSentences(0);
        scoreWithOutInputs.setCharacters(0);
        scoreWithOutInputs.setSyllables(0);
        scoreWithOutInputs.setPolysyllables(0);

        scoreWithOutInputs.getAges().put("0", 0.0);
        scoreWithOutInputs.getAges().put("0", 0.0);
        scoreWithOutInputs.getAges().put("0", 0.0);
        scoreWithOutInputs.getAges().put("0", 0.0);
    }

    @Test
    void getARI_Index() {
        assertEquals(6.29, scoreWithInputs.getIndexAutomatedReadability(), 0.01);
    }

    @Test
    void whenNoInputsThenARI_IndexNegativeOne() {
        assertEquals(-1.0, scoreWithOutInputs.getIndexAutomatedReadability(), 0.001);
    }

    @Test
    void getFK_Index() {
        assertEquals(4.0, scoreWithInputs.getIndexFleschKincaid(), 0.01);
    }

    @Test
    void whenNoInputsThenFK_IndexNegativeOne() {
        assertEquals(-1.0, scoreWithOutInputs.getIndexFleschKincaid(), 0.001);
    }

    @Test
    void getSMOG_Index() {
        assertEquals(8.84, scoreWithInputs.getIndexSMOG(), 0.01);
    }

    @Test
    void whenNoInputsThenSMOG_IndexNegativeOne() {
        assertEquals(-1.0, scoreWithOutInputs.getIndexSMOG(), 0.001);
    }

    @Test
    void getCL_Index() {
        assertEquals(10.21, scoreWithInputs.getIndexColemanLiau(), 0.01);
    }

    @Test
    void whenNoInputsThenCL_IndexNegativeOne() {
        assertEquals(-1.0, scoreWithOutInputs.getIndexColemanLiau(), 0.001);
    }

    @Test
    void getAverage() {
        assertEquals(13.25, scoreWithInputs.getAverageAge(), 0.01);
    }

    @Test
    void whenNoInputsThenAverageZero() {
        assertEquals(0.0, scoreWithOutInputs.getAverageAge(), 0.01);
    }
}