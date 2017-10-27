package org.yakimovdenis.console.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.yakimovdenis.console.model.FileStatistics;
import org.yakimovdenis.console.support.FileStatisticsRowMapper;
import org.yakimovdenis.console.support.LineStatisticsRowMapper;
import org.yakimovdenis.console.support.QueryConstants;
import org.yakimovdenis.stats.LineStatisticsResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FileStatisticsDaoImpl implements FileStatisticsDao {

    @Autowired
    private LineStatisticsRowMapper lineStatisticsRowMapper;

    @Autowired
    private FileStatisticsRowMapper fileStatisticsRowMapper;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    @Transactional
    public FileStatistics save(FileStatistics fileStatistics) {
        Map<String, Object> sqlParameters = new HashMap<>();
        sqlParameters.put("file_name", fileStatistics.getFileName());
        sqlParameters.put("upload_date", fileStatistics.getFileUploadDate());
        int fileId = namedParameterJdbcTemplate.update(QueryConstants.SAVE_FILE_STATISTIC, sqlParameters);
        for (LineStatisticsResult result : fileStatistics.getLineStatistics()) {
            saveLineStatistic(fileId, result);
        }
        fileStatistics.setId(fileId);
        return fileStatistics;
    }

    @Override
    @Transactional
    public FileStatistics get(Integer id) {
        Map<String, Object> sqlParameters = new HashMap<>();
        sqlParameters.put("file_id", id);
        FileStatistics fileStatistics = namedParameterJdbcTemplate.query(QueryConstants.GET_FILE, sqlParameters, fileStatisticsRowMapper).stream().findFirst().get();
        fileStatistics.setLineStatistics(getLinesStatistic(fileStatistics.getId()));
        return fileStatistics;
    }

    @Override
    public boolean deleteFileStatistics(Integer id) {
        Map<String, Object> sqlParameters = new HashMap<>();
        sqlParameters.put("file_id", id);
        return namedParameterJdbcTemplate.update(QueryConstants.DELETE_FILE, sqlParameters) != 0;
    }

    @Override
    public List<FileStatistics> getFileNameAndIds() {
        return namedParameterJdbcTemplate.query(QueryConstants.GET_FILE_NAMES, (Map<String, ?>) null, fileStatisticsRowMapper);
    }

    private int saveLineStatistic(Integer fileId, LineStatisticsResult lineStatisticsResult) {
        Map<String, Object> sqlParameters = new HashMap<>();
        sqlParameters.put("line", lineStatisticsResult.getLine());
        sqlParameters.put("longest_word", lineStatisticsResult.getLongestWord());
        sqlParameters.put("shortest_word", lineStatisticsResult.getShortestWord());
        sqlParameters.put("average_word_length", lineStatisticsResult.getAverageWordLength());
        sqlParameters.put("file_id", fileId);
        return namedParameterJdbcTemplate.update(QueryConstants.SAVE_LINE_STATISTIC, sqlParameters);
    }

    private List<LineStatisticsResult> getLinesStatistic(Integer lineId) {
        Map<String, Object> sqlParameters = new HashMap<>();
        sqlParameters.put("file_id", lineId);
        return namedParameterJdbcTemplate.query(QueryConstants.GET_LINES, sqlParameters, lineStatisticsRowMapper);
    }
}
