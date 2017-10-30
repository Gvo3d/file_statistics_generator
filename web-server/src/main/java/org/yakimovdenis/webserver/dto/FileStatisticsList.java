package org.yakimovdenis.webserver.dto;

import lombok.Data;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;

import java.util.List;
import java.util.Set;

@Data
public class FileStatisticsList {
    private int pageNo;
    private int pageSize;
    private int pagesCount;
    private List<FileStatisticsEntity> fileStatistics;

    public FileStatisticsList(int pageNo, int pageSize, int pagesCount, List<FileStatisticsEntity> fileStatistics) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pagesCount = pagesCount;
        this.fileStatistics = fileStatistics;
    }
}
