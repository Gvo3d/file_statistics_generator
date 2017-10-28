package org.yakimovdenis.webserver.service;

import org.yakimovdenis.webserver.models.FileStatisticsEntity;

import java.util.List;

public interface StatisticsService {
    FileStatisticsEntity getFileStatistics(Integer id);
    boolean deleteFileStatistics(Integer id);
    FileStatisticsEntity persistFileStatistics(FileStatisticsEntity entity);
    List<FileStatisticsEntity> getFileStatisticsList();
}
