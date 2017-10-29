package org.yakimovdenis.webserver.models;

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
    private Integer id;
    @Column(name="line")
    private String line;
    @Column(name="longest_word")
    private String longestWord;
    @Column(name="shortest_word")
    private String shortestWord;
    @Column(name="average_word_length")
    private float averageWordLength;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "file_id", nullable = false)
    private FileStatisticsEntity fileStatisticsEntity;
}
