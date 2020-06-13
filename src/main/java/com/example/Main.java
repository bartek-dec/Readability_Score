package com.example;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Formatter formatter = new Formatter();
        TextReader reader = new TextReader(args[0]);
        TextAnalyzer analyzer = new TextAnalyzer(reader, formatter);

        analyzer.analyzeText();

        System.out.println(analyzer.getTextStatistics());

        String response;
        do {
            System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

            String input = scanner.nextLine().toLowerCase();

            response = (analyzer.getIndexes(input));
            System.out.println(response);

        } while (Objects.equals(response, "Please, provide appropriate score."));

    }
}
