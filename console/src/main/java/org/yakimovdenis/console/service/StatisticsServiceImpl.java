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
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@Service
public class StatisticsServiceImpl implements StatisticsService {
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
            log.error("No such file was found: " + filename, e);
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
                paths.filter(Files::isRegularFile).forEach(x -> fileList.add(x.toString()));
            }
        } catch (IOException e) {
            log.error("Can't read directory: " + dirName, e);
            return Collections.emptyList();
        }
        Set<Future<List<FileStatistics>>> set = new HashSet<>();
        Runtime rnt = Runtime.getRuntime();
        int cpus = rnt.availableProcessors();
        ExecutorService threadPool = Executors.newFixedThreadPool(cpus);
        int startingPoint = 0;
        int diy = fileList.size() / cpus;
        for (int i = 0; i < cpus; i++) {
            int enddingPoint = startingPoint + diy <= fileList.size() ? startingPoint + diy : fileList.size();
            DataMatcher matcher = new DataMatcher(fileList.subList(startingPoint, enddingPoint), fileStatisticsDao, statisticsFileReader);
            Future<List<FileStatistics>> future = threadPool.submit(matcher);
            set.add(future);
            startingPoint = enddingPoint;
        }
        List<FileStatistics> fileStatistics = new ArrayList<>(fileList.size());
        for (Future<List<FileStatistics>> future : set) {
            try {
                fileStatistics.addAll(future.get());
            } catch (Exception e) {
                log.warn(e);
            }
        }
        return fileStatistics;
    }

    @Override
    public List<FileStatistics> getFileNameAndIds() {
        return fileStatisticsDao.getFileNameAndIds();
    }

    private class DataMatcher implements Callable<List<FileStatistics>> {
        private List<String> preData;
        private FileStatisticsDao dao;
        private StatisticsFileReader reader;

        DataMatcher(List<String> preData, FileStatisticsDao dao, StatisticsFileReader reader) {
            this.preData = preData;
            this.dao = dao;
            this.reader = reader;
        }

        @Override
        public List<FileStatistics> call() throws Exception {
            List<FileStatistics> result = new ArrayList<>(preData.size());
            for (String fileName : preData) {
                File file = new File(fileName);
                FileStatistics fileStatistics;
                try {
                    fileStatistics = new FileStatistics(fileName, statisticsFileReader.resolveFile(file));
                } catch (NoSuchFileException e) {
                    log.error("No such file was found: " + fileName, e);
                    throw e;
                }
                result.add(dao.save(fileStatistics));
            }
            return result;
        }
    }
}
