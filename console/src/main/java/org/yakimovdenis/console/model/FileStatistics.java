package org.yakimovdenis.console.model;

import lombok.Data;
import org.yakimovdenis.stats.LineStatisticsResult;

import java.util.Date;
import java.util.List;

@Data
public class FileStatistics {
    private Integer id;
    private String fileName;
    private Date fileUploadDate;
    private List<LineStatisticsResult> lineStatistics;

    public FileStatistics(String fileName, List<LineStatisticsResult> lineStatistics) {
        this.fileName = fileName;
        this.fileUploadDate = new Date(System.currentTimeMillis());
        this.lineStatistics = lineStatistics;
    }

    public FileStatistics() {
    }

    @Override
    public String toString() {
        return "FileStatistics id=" + id + System.lineSeparator() +
                "fileName='" + fileName + '\'' + System.lineSeparator() +
                "fileUploadDate=" + fileUploadDate + System.lineSeparator() +
                "lineStatistics=" + System.lineSeparator() + lineStatistics + '}';
    }
}
