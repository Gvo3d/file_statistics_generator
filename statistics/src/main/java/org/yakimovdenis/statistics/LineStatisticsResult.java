package org.yakimovdenis.statistics;

import lombok.Data;

@Data
public class LineStatisticsResult {
    private final static String LINE_SEPARATOR = System.lineSeparator();
    private String line;
    private String longestWord;
    private String shortestWord;
    private float averageWordLength;

    LineStatisticsResult(String line, String longestWord, String shortestWord, float averageWordLength) {
        this.line = line;
        this.longestWord = longestWord;
        this.shortestWord = shortestWord;
        this.averageWordLength = averageWordLength;
    }

    @Override
    public String toString() {
        String lineSize = line != null ? String.valueOf(line.length()) : "null";
        return "LineStatisticsResult{" + LINE_SEPARATOR +
                "line='" + line + "\'," + LINE_SEPARATOR +
                "longestWord='" + longestWord + '\'' +
                ", shortestWord='" + shortestWord + '\'' +
                ", lineLenght=" + lineSize +
                ", averageWordLength=" + averageWordLength +
                '}';
    }
}
