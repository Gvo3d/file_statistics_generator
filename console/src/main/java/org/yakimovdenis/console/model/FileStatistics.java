package org.yakimovdenis.console.model;

import lombok.Data;
import lombok.Setter;
import org.yakimovdenis.statistics.LineStatisticsResult;

import java.util.Date;
import java.util.List;

@Data
public class FileStatistics {
    @Setter
    private Integer id;
    private String fileName;
    private Date fileUploadDate;
    private String fileData;
    private List<LineStatisticsResult> lineStatistics;

    public FileStatistics(String fileName, String fileData, List<LineStatisticsResult> lineStatistics) {
        this.fileName = fileName;
        this.fileData = fileData;
        this.fileUploadDate = new Date(System.currentTimeMillis());
        this.lineStatistics = lineStatistics;
    }
}
