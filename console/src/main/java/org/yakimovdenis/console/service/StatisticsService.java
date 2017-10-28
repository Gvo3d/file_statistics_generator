package org.yakimovdenis.console.service;

import org.yakimovdenis.console.model.FileStatistics;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.List;

public interface StatisticsService {
    FileStatistics persistFileStatistics(String filename) throws NoSuchFileException;

    FileStatistics getStatisticsForFile(Integer id);

    boolean deleteFileStatistics(Integer id);

    List<FileStatistics> persistFileStatisticsInDirectory(String dirName);

    List<FileStatistics> getFileNameAndIds();
}
