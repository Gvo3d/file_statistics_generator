package main.java.stats;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class StatisticsResolver {
    private final static String DEFAULT_WORD = "";
    private static final Logger log = Logger.getLogger(OrderLogic.class);

    private String splitter = "  ";
    private static final int DEFAULT_STATISTICS_SIZE = 30;

    private StringLengthComparator minComparator = new StringLengthComparator(true);
    private StringLengthComparator maxComparator = new StringLengthComparator(false);

    public LineStatisticsResult[] getLineStatisticsForFile(File file) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        ArrayList<LineStatisticsResult> results = new ArrayList<>(DEFAULT_STATISTICS_SIZE);

        try {
            while ((line = reader.readLine()) != null) {
                results.add(getLineStatistics(line));
            }
        } catch (IOException e){

    } finally

    {
        reader.close();
    }


    public LineStatisticsResult getLineStatistics(String line) {
        String[] words = line.split(splitter);
        return new LineStatisticsResult(line, getWord(words, true).orElse(DEFAULT_WORD), getWord(words, false).orElse(DEFAULT_WORD), (float) averageWordLenght(words).orElse(0d));
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

}
