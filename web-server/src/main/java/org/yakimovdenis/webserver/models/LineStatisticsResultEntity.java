package org.yakimovdenis.webserver.models;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.yakimovdenis.webserver.dao.FileStatisticsEntityDao;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="line_statistics")
@EqualsAndHashCode(exclude = "fileStatisticsEntity")
@ToString(exclude = "fileStatisticsEntity")
public class LineStatisticsResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonView(JacksonView.FullStatistic.class)
    private Integer id;
    @Column(name="line")
    @JsonView(JacksonView.FullStatistic.class)
    private String line;
    @Column(name="longest_word")
    @JsonView(JacksonView.FullStatistic.class)
    private String longestWord;
    @Column(name="shortest_word")
    @JsonView(JacksonView.FullStatistic.class)
    private String shortestWord;
    @Column(name="average_word_length")
    @JsonView(JacksonView.FullStatistic.class)
    private float averageWordLength;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileStatisticsEntity fileStatisticsEntity;
}
