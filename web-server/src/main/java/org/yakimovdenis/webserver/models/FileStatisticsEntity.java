package org.yakimovdenis.webserver.models;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.yakimovdenis.stats.LineStatisticsResult;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name="files")
@EqualsAndHashCode(exclude = {"lineStatistics"})
public class FileStatisticsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonView(JacksonView.WithoutLineStatistics.class)
    private Integer id;
    @Column(name="filename")
    @JsonView(JacksonView.WithoutLineStatistics.class)
    private String filename;
    @Column(name="shortest_word")
    @JsonView(JacksonView.WithoutLineStatistics.class)
    private String shortestWord;
    @Column(name="longest_word")
    @JsonView(JacksonView.WithoutLineStatistics.class)
    private String longestWord;
    @Column(name="average_word_length")
    @JsonView(JacksonView.WithoutLineStatistics.class)
    private float averageWordLength;
    @Column(name="size")
    @JsonView(JacksonView.WithoutLineStatistics.class)
    private int size;
    @Column(name="created")
    @JsonView(JacksonView.WithoutLineStatistics.class)
    private Date uploadDate;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fileStatisticsEntity")
    @JsonView(JacksonView.FullStatistic.class)
    @OrderBy("id ASC")
    private SortedSet<LineStatisticsResultEntity> lineStatistics = new TreeSet<>();

    public void setLineStatisticsFromResult(List<LineStatisticsResult> lines){
        TreeSet<LineStatisticsResultEntity> resultSet = new TreeSet<>((Comparator<LineStatisticsResultEntity>) (o1, o2) -> 1);
        for (LineStatisticsResult line: lines){
            LineStatisticsResultEntity entity = new LineStatisticsResultEntity();
            entity.setLine(line.getLine());
            entity.setShortestWord(line.getShortestWord());
            entity.setLongestWord(line.getLongestWord());
            entity.setAverageWordLength(line.getAverageWordLength());
            resultSet.add(entity);
        }
        this.lineStatistics = resultSet;
    }
}
