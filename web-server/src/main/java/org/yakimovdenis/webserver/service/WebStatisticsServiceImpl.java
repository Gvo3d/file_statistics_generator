package org.yakimovdenis.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yakimovdenis.webserver.dao.FileStatisticsEntityDao;
import org.yakimovdenis.webserver.dao.LineStatisticsEntityDao;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;
import org.yakimovdenis.webserver.models.LineStatisticsResultEntity;
import org.yakimovdenis.console.support.StringComparator;

import java.util.List;

@Service
public class WebStatisticsServiceImpl implements WebStatisticsService {
    private final static String DEFAULT_WORD = "";

    @Autowired
    private FileStatisticsEntityDao fileStatisticsEntityDao;

    @Autowired
    private LineStatisticsEntityDao lineStatisticsEntityDao;

    @Autowired
    private StringComparator stringComparator;

    private void fillFileModelWithData(FileStatisticsEntity entity) {
        entity.setShortestWord(entity.getLineStatistics().stream().map(LineStatisticsResultEntity::getShortestWord).min(stringComparator).orElse(DEFAULT_WORD));
        entity.setLongestWord(entity.getLineStatistics().stream().map(LineStatisticsResultEntity::getLongestWord).max(stringComparator).orElse(DEFAULT_WORD));
        entity.setAverageWordLength((float) entity.getLineStatistics().stream().mapToDouble(LineStatisticsResultEntity::getAverageWordLength).average().orElse(0d));
    }

    private void fillFileLinesWithParentConnection(FileStatisticsEntity entity) {
        for (LineStatisticsResultEntity line : entity.getLineStatistics()) {
            line.setFileStatisticsEntity(entity);
        }
    }

    @Override
    @Transactional
    public FileStatisticsEntity getFileStatistics(Integer id) {
        FileStatisticsEntity entity = fileStatisticsEntityDao.findOne(id);
        if (entity != null) {
            entity.getLineStatistics().size();
        }
        return entity;
    }

    @Override
    public boolean deleteFileStatistics(Integer id) {
        try {
            fileStatisticsEntityDao.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public FileStatisticsEntity persistFileStatistics(FileStatisticsEntity entity) {
        fillFileLinesWithParentConnection(entity);
        fillFileModelWithData(entity);
        return fileStatisticsEntityDao.save(entity);
    }

    @Override
    public Iterable<FileStatisticsEntity> persistFileStatistics(List<FileStatisticsEntity> entities) {
        for (FileStatisticsEntity entity : entities) {
            fillFileLinesWithParentConnection(entity);
            fillFileModelWithData(entity);
        }
        return fileStatisticsEntityDao.save(entities);
    }

    @Override
    public Page<FileStatisticsEntity> getFileStatisticsList(int page, int quantity, String sort, boolean ascend) {
        if (sort == null) {
            sort = "id";
        }
        return fileStatisticsEntityDao.findAll(new PageRequest(page, quantity, ascend ? Sort.Direction.ASC : Sort.Direction.DESC, sort));
    }
}
