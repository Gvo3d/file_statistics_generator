package main.java.stats;

public class LineStatisticsResult {
    private String line;
    private String longestWord;
    private String shortestWord;
    private float averageWordLenght;

    public LineStatisticsResult(String line, String longestWord, String shortestWord, float averageWordLenght) {
        this.line = line;
        this.longestWord = longestWord;
        this.shortestWord = shortestWord;
        this.averageWordLenght = averageWordLenght;
    }

    public String getLine() {
        return line;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public String getShortestWord() {
        return shortestWord;
    }

    public float getAverageWordLenght() {
        return averageWordLenght;
    }

    @Override
    public String toString() {
        return "LineStatisticsResult{" +
                "line='" + line + '\'' +
                ", longestWord='" + longestWord + '\'' +
                ", shortestWord='" + shortestWord + '\'' +
                ", lineLenght=" + line.length() +
                ", averageWordLenght=" + averageWordLenght +
                '}';
    }
}
