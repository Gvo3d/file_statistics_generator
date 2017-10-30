package org.yakimovdenis.console.model;

import lombok.Data;
import org.yakimovdenis.console.support.StringComparator;
import org.yakimovdenis.stats.LineStatisticsResult;

import java.util.Date;
import java.util.List;

@Data
public class FileStatistics {
    private static final StringComparator STRING_COMPARATOR = new StringComparator();
    private final static String DEFAULT_WORD = "";

    private Integer id;
    private String fileName;
    private Date fileUploadDate;
    private int size;
    private String longestWord;
    private String shortestWord;
    private float averageWordLength;
    private List<LineStatisticsResult> lineStatistics;

    public FileStatistics(String fileName, List<LineStatisticsResult> lineStatistics) {
        this.fileName = fileName;
        this.fileUploadDate = new Date(System.currentTimeMillis());
        setLineStatistics(lineStatistics);
    }

    public FileStatistics() {
    }

    public void setLineStatistics(List<LineStatisticsResult> lineStatistics) {
        this.lineStatistics = lineStatistics;
        this.size = lineStatistics.size();
        this.shortestWord = this.getLineStatistics().stream().map(LineStatisticsResult::getShortestWord).min(STRING_COMPARATOR).orElse(DEFAULT_WORD);
        this.longestWord = this.getLineStatistics().stream().map(LineStatisticsResult::getLongestWord).max(STRING_COMPARATOR).orElse(DEFAULT_WORD);
        this.setAverageWordLength((float) this.getLineStatistics().stream().mapToDouble(LineStatisticsResult::getAverageWordLength).average().orElse(0d));
    }

    @Override
    public String toString() {
        return "FileStatistics id=" + id + System.lineSeparator() +
                ", fileName='" + fileName + '\'' + System.lineSeparator() +
                ", fileUploadDate=" + fileUploadDate + System.lineSeparator() +
                ", size=" + size + System.lineSeparator() +
                ", longestWord='" + longestWord + '\'' + System.lineSeparator() +
                ", shortestWord='" + shortestWord + '\'' + System.lineSeparator() +
                ", averageWordLength=" + averageWordLength + System.lineSeparator() +
                ", lineStatistics=" + lineStatistics + '}';
    }
}