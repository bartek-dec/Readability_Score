package com.example;

import java.io.*;
import java.util.stream.Collectors;

public class TextReader {

    private final String path = "./src/main/resources/";
    private String fileName;

    public TextReader(String fileName) {
        this.fileName = fileName;

    }

    public String getText() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getPath()))) {
            return readAllLines(bufferedReader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    String getPath() {
        return path + fileName;
    }

    private String readAllLines(BufferedReader reader) {
        return reader.lines()
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
