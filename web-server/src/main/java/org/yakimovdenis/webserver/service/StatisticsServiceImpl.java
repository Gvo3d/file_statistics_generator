package org.yakimovdenis.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yakimovdenis.stats.StringLengthComparator;
import org.yakimovdenis.webserver.dao.FileStatisticsEntityDao;
import org.yakimovdenis.webserver.dao.LineStatisticsEntityDao;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;
import org.yakimovdenis.webserver.models.LineStatisticsResultEntity;
import org.yakimovdenis.webserver.support.StringComparator;

import java.util.Comparator;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService{
    private final static String DEFAULT_WORD = "";

    @Autowired
    private FileStatisticsEntityDao fileStatisticsEntityDao;

    @Autowired
    private LineStatisticsEntityDao lineStatisticsEntityDao;

    @Autowired
    private StringComparator stringComparator;

    public void fillFileModelWithData(FileStatisticsEntity entity) {
        entity.setShortestWord(entity.getLineStatistics().stream().map(LineStatisticsResultEntity::getShortestWord).min(stringComparator).orElse(DEFAULT_WORD));
        entity.setLongestWord(entity.getLineStatistics().stream().map(LineStatisticsResultEntity::getShortestWord).min(stringComparator).orElse(DEFAULT_WORD));
        entity.setAverageWordLength((float) entity.getLineStatistics().stream().mapToDouble(LineStatisticsResultEntity::getAverageWordLength).average().orElse(0d));
    }

    @Override
    public FileStatisticsEntity getFileStatistics(Integer id) {
        return null;
    }

    @Override
    public boolean deleteFileStatistics(Integer id) {
        return false;
    }

    @Override
    public FileStatisticsEntity persistFileStatistics(FileStatisticsEntity entity) {
        return null;
    }

    @Override
    @Transactional
    public List<FileStatisticsEntity> getFileStatisticsList() {
        return null;
    }
}
