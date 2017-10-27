package org.yakimovdenis.console.dao;

import org.yakimovdenis.console.model.FileStatistics;

import java.util.List;

public interface FileStatisticsDao {
    FileStatistics save(FileStatistics fileStatistics);
    FileStatistics get(Integer id);
    boolean deleteFileStatistics(Integer id);
    List<FileStatistics> getFileNameAndIds();
}
