package org.yakimovdenis.webserver.models;

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
    private Integer id;
    @Column(name="filename")
    private String filename;
    @Column(name="shortest_word")
    private String shortestWord;
    @Column(name="longest_word")
    private String longestWord;
    @Column(name="average_word_length")
    private float averageWordLength;
    @Column(name="size")
    private int size;
    @Column(name="created")
    private Date uploadDate;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fileStatisticsEntity")
    private Set<LineStatisticsResultEntity> lineStatistics = new HashSet<>();
}
