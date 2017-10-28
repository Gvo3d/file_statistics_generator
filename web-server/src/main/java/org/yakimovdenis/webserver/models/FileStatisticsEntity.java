package org.yakimovdenis.webserver.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="files")
public class FileStatisticsEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    private String shortestWord;
    private String longestWord;
    private float averageWordLength;
    @Column(name="created")
    private Date uploadDate;
    @OneToMany
    private List<LineStatisticsResultEntity> lineStatistics;
}
