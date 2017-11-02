package org.yakimovdenis.webserver.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;

import java.util.List;

public interface WebStatisticsService {
    FileStatisticsEntity getFileStatistics(Integer id);
    boolean deleteFileStatistics(Integer id);
    FileStatisticsEntity persistFileStatistics(FileStatisticsEntity entity);
    Iterable<FileStatisticsEntity> persistFileStatistics(MultipartFile[] uploadfiles);
    Page<FileStatisticsEntity> getFileStatisticsList(int page, int quantity, String sort, boolean ascend);
    Integer getFileStatisticsPagesCount(int quantity);
}
