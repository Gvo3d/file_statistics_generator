package stats;

import java.util.*;

public class StatisticsResolver {
    private final static String DEFAULT_WORD = "";
    private final static String SPLITTER = " ";
    private StringLengthComparator minComparator = new StringLengthComparator(true);
    private StringLengthComparator maxComparator = new StringLengthComparator(false);

    public List<LineStatisticsResult> getLineStatisticsForFile(String[] lines) {
        ArrayList<LineStatisticsResult> results = new ArrayList<>(lines.length);
        for (String line : lines) {
            results.add(getLineStatistics(line));
        }
        return results;
    }

    private LineStatisticsResult getLineStatistics(String line) {
        if (line!=null) {
            String[] words = line.split(SPLITTER);
            return new LineStatisticsResult(line, getWord(words, true).orElse(DEFAULT_WORD), getWord(words, false).orElse(DEFAULT_WORD), (float) averageWordLenght(words).orElse(0d));
        } else {
            return new LineStatisticsResult(null,null,null,0);
        }
    }

    private Optional<String> getWord(String[] words, boolean longest) {
        if (longest) {
            return Arrays.stream(words).min(minComparator);
        } else {
            return Arrays.stream(words).min(maxComparator);
        }
    }

    private OptionalDouble averageWordLenght(String[] words) {
        return Arrays.stream(words).mapToInt(String::length).average();
    }
}
