package com.example;

public class Formatter {

    private Score score;

    public Formatter() {
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getTextStatistics() {
        StringBuilder builder = new StringBuilder();

        builder.append("Words: ");
        builder.append(String.format("%.0f", score.getWords()));
        builder.append("\n");

        builder.append("Sentences: ");
        builder.append(String.format("%.0f", score.getSentences()));
        builder.append("\n");

        builder.append("Characters: ");
        builder.append(String.format("%.0f", score.getCharacters()));
        builder.append("\n");

        builder.append("Syllables: ");
        builder.append(String.format("%.0f", score.getSyllables()));
        builder.append("\n");

        builder.append("Polysyllables: ");
        builder.append(String.format("%.0f", score.getPolysyllables()));
        builder.append("\n");

        return builder.toString();
    }

    public String getTextIndexes(String s) {
        switch (s) {
            case "ari":
                return "\n" + getARI_Index();
            case "fk":
                return "\n" + getFK_Index();
            case "smog":
                return "\n" + getSMOG_Index();
            case "cl":
                return "\n" + getCL_Index();
            case "all":
                return "\n" + getAll();
            default:
                return "Please, provide appropriate score.";
        }
    }

    private String getARI_Index() {
        StringBuilder builder = new StringBuilder();

        builder.append("Automated Readability Index: ");
        builder.append(String.format("%.2f", score.getIndexAutomatedReadability()));
        builder.append(" (about ").append(getAge(score.getIndexAutomatedReadability())).append(" year olds).");

        return builder.toString();
    }

    private String getFK_Index() {
        StringBuilder builder = new StringBuilder();

        builder.append("Flesch–Kincaid readability tests: ");
        builder.append(String.format("%.2f", score.getIndexFleschKincaid()));
        builder.append(" (about ").append(getAge(score.getIndexFleschKincaid())).append(" year olds).");

        return builder.toString();
    }

    private String getSMOG_Index() {
        StringBuilder builder = new StringBuilder();

        builder.append("Simple Measure of Gobbledygook: ");
        builder.append(String.format("%.2f", score.getIndexSMOG()));
        builder.append(" (about ").append(getAge(score.getIndexSMOG())).append(" year olds).");

        return builder.toString();
    }

    private String getCL_Index() {
        StringBuilder builder = new StringBuilder();

        builder.append("Coleman–Liau index: ");
        builder.append(String.format("%.2f", score.getIndexColemanLiau()));
        builder.append(" (about ").append(getAge(score.getIndexColemanLiau())).append(" year olds).");

        return builder.toString();
    }

    private String getAll() {
        StringBuilder builder = new StringBuilder();

        builder.append(getARI_Index()).append("\n");
        builder.append(getFK_Index()).append("\n");
        builder.append(getSMOG_Index()).append("\n");
        builder.append(getCL_Index()).append("\n").append("\n");
        builder.append("This text should be understood in average by ");
        builder.append(score.getAverageAge());
        builder.append(" year olds.");

        return builder.toString();
    }

    private String getAge(double value) {
        int index = (int) Math.round(value);
        String age;

        switch (index) {
            case 1:
                age = "6";
                score.getAges().put(age, 6.0);
                return age;
            case 2:
                age = "7";
                score.getAges().put(age, 7.0);
                return age;
            case 3:
                age = "9";
                score.getAges().put(age, 9.0);
                return age;
            case 4:
                age = "10";
                score.getAges().put(age, 10.0);
                return age;
            case 5:
                age = "11";
                score.getAges().put(age, 11.0);
                return age;
            case 6:
                age = "12";
                score.getAges().put(age, 12.0);
                return age;
            case 7:
                age = "13";
                score.getAges().put(age, 13.0);
                return age;
            case 8:
                age = "14";
                score.getAges().put(age, 14.0);
                return age;
            case 9:
                age = "15";
                score.getAges().put(age, 15.0);
                return age;
            case 10:
                age = "16";
                score.getAges().put(age, 16.0);
                return age;
            case 11:
                age = "17";
                score.getAges().put(age, 17.0);
                return age;
            case 12:
                age = "18";
                score.getAges().put(age, 18.0);
                return age;
            case 13:
                age = "24";
                score.getAges().put(age, 24.0);
                return age;
            case 14:
                age = "more than 24";
                score.getAges().put(age, 25.0);
                return age;
            default:
                age = "0";
                score.getAges().put(age, 0.0);
                return age;
        }
    }
}
