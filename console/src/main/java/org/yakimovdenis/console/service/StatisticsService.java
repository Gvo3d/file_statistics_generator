package org.yakimovdenis.console.service;

import org.yakimovdenis.console.model.FileStatistics;
import org.yakimovdenis.statistics.LineStatisticsResult;

import java.io.File;
import java.util.List;

public interface StatisticsService {
    FileStatistics persistFileStatistics (File file);
    FileStatistics getStatisticsForFile(Integer id);
    boolean updateFileStatistics(FileStatistics fileStatistics);
    boolean deleteFileStatistics(Integer id);
    List<FileStatistics> persistFileStatisticsInDirectory(String dirName);
}
