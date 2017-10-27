package org.yakimovdenis.console.support;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.yakimovdenis.console.model.FileStatistics;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FileStatisticsRowMapper implements RowMapper<FileStatistics> {
    @Override
    public FileStatistics mapRow(ResultSet rs, int rowNum) throws SQLException {
        FileStatistics fileStatistics = new FileStatistics();
        fileStatistics.setId(rs.getInt("id"));
        fileStatistics.setFileName(rs.getString("filename"));
        fileStatistics.setFileUploadDate(rs.getDate("created"));
        return fileStatistics;
    }
}
