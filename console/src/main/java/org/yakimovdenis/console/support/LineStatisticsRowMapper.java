package org.yakimovdenis.console.support;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.yakimovdenis.statistics.LineStatisticsResult;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LineStatisticsRowMapper implements RowMapper<LineStatisticsResult> {
    @Override
    public LineStatisticsResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LineStatisticsResult(rs.getString("line"), rs.getString("longest_word"), rs.getString("shortest_word"), rs.getFloat("average_word_length"));
    }
}
