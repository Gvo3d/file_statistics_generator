package org.yakimovdenis.console.dao;

import org.yakimovdenis.console.model.FileStatistics;

public interface FileStatisticsDao {
    FileStatistics save(FileStatistics fileStatistics);
    FileStatistics get(Integer id);
    boolean updateFileStatistics(FileStatistics fileStatistics);
    boolean deleteFileStatistics(Integer id);
}
