package org.yakimovdenis.console.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.yakimovdenis.console.dao.FileStatisticsDao;
import org.yakimovdenis.console.model.FileStatistics;
import org.yakimovdenis.stats.StatisticsFileReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

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
        return fileStatisticsDao.get(id);
    }

    @Override
    public boolean deleteFileStatistics(Integer id) {
        return fileStatisticsDao.deleteFileStatistics(id);
    }

    @Override
    public List<FileStatistics> persistFileStatisticsInDirectory(String dirName) {
        List<String> fileList = new ArrayList<>();
        try {
            try (Stream<Path> paths = Files.walk(Paths.get(dirName))) {
                paths.filter(Files::isRegularFile).forEach(x->fileList.add(x.toString()));
            }
        } catch (IOException e) {
            log.error("Can't read directory: "+dirName, e);
            return Collections.emptyList();
        }
        List<FileStatistics> fileStatistics = new ArrayList<>(fileList.size());
        for (String file:fileList){
            try {
                fileStatistics.add(persistFileStatistics(file));
            } catch (NoSuchFileException e) {
                log.error("No such file: "+file, e);
            }
        }
        return fileStatistics;
    }

    @Override
    public List<FileStatistics> getFileNameAndIds() {
        return fileStatisticsDao.getFileNameAndIds();
    }
}
