package org.yakimovdenis.webserver.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="line_statistics")
public class LineStatisticsResultEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ManyToOne
    private FileStatisticsEntity fileStatisticsEntity;
}
