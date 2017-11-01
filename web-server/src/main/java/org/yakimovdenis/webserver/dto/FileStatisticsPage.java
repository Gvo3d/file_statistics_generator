package org.yakimovdenis.webserver.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;
import org.yakimovdenis.webserver.models.JacksonView;

import java.util.List;
import java.util.Set;

@Data
public class FileStatisticsPage {
    @JsonView(JacksonView.WithoutLineStatistics.class)
    private int pageNo;
    @JsonView(JacksonView.WithoutLineStatistics.class)
    private int pageSize;
    @JsonView(JacksonView.WithoutLineStatistics.class)
    private int pagesCount;
    @JsonView(JacksonView.WithoutLineStatistics.class)
    private List<FileStatisticsEntity> fileStatistics;

    public FileStatisticsPage(int pageNo, int pageSize, int pagesCount, List<FileStatisticsEntity> fileStatistics) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pagesCount = pagesCount;
        this.fileStatistics = fileStatistics;
    }

    public FileStatisticsPage(Page<FileStatisticsEntity> page) {
        this.pageNo = page.getNumber();
        this.pageSize = page.getSize();
        this.pagesCount = page.getTotalPages();
        this.fileStatistics = page.getContent();
    }
}
