package org.yakimovdenis.console.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.yakimovdenis.console.dao.FileStatisticsDao;
import org.yakimovdenis.console.model.FileStatistics;
import org.yakimovdenis.stats.StatisticsFileReader;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService{
    private static final Logger log = Logger.getLogger(StatisticsService.class);

    private StatisticsFileReader statisticsFileReader = new StatisticsFileReader();

    @Autowired
    private FileStatisticsDao fileStatisticsDao;

    @Override
    public FileStatistics persistFileStatistics(String filename) throws NoSuchFileException {
        File file = new File(filename);
        FileStatistics fileStatistics;
        try {
             fileStatistics = new FileStatistics(filename, statisticsFileReader.resolveFile(file));
        } catch (NoSuchFileException e) {
            log.error("No such file was found: "+filename, e);
            throw e;
        }
        return fileStatisticsDao.save(fileStatistics);
    }

    @Override
    public FileStatistics getStatisticsForFile(Integer id) {
        return null;
    }

    @Override
    public boolean updateFileStatistics(FileStatistics fileStatistics) {
        return false;
    }

    @Override
    public boolean deleteFileStatistics(Integer id) {
        return false;
    }

    @Override
    public List<FileStatistics> persistFileStatisticsInDirectory(String dirName) {
        return null;
    }
}
