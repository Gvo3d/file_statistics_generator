package org.yakimovdenis.webserver.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name="files")
@EqualsAndHashCode(exclude = {"shortestWord", "longestWord", "averageWordLength", "lineStatistics"})
public class FileStatisticsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="filename")
    private String filename;
    @Transient
    private String shortestWord;
    @Transient
    private String longestWord;
    @Transient
    private float averageWordLength;
    @Column(name="created")
    private Date uploadDate;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fileStatisticsEntity")
    private Set<LineStatisticsResultEntity> lineStatistics = new HashSet<>();
}
