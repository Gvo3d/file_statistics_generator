package org.yakimovdenis.webserver.models;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
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
    private Set<LineStatisticsResultEntity> lineStatistics = new HashSet<>();
}
