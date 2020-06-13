package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TextReaderTest {

    private final String text = "This is simple text with one polysyllable.";
    private final String path = "./src/test/java/resources/";

    @Test
    void readInputSuccessful() {
        String fileName = "testFile.txt";
        TextReader reader = new TextReader(fileName) {
            String getPath() {
                return path + fileName;
            }
        };

        String result = reader.getText();
        assertEquals(text, result);
    }

    @Test
    void readInputFileNotExist() {
        String fileName = "testt.txt";
        TextReader reader = new TextReader(fileName) {
            String getPath() {
                return path + fileName;
            }
        };

        assertNull(reader.getText());
    }
}