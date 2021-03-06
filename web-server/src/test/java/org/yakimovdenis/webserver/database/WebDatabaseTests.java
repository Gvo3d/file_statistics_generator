package org.yakimovdenis.webserver.database;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.yakimovdenis.webserver.dbconfig.TestJpaConfig;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;
import org.yakimovdenis.webserver.models.LineStatisticsResultEntity;
import org.yakimovdenis.webserver.service.WebStatisticsService;

import java.util.*;

import static org.junit.Assert.*;

@ContextConfiguration(classes = {TestJpaConfig.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WebDatabaseTests {
    private final String SEPARATOR = "**********************************************************";

    @Autowired
    private WebStatisticsService webStatisticsService;

    @Test
    public void doTest(){
        FileStatisticsEntity fileStatisticsEntity = new FileStatisticsEntity();
        fileStatisticsEntity.setFilename("test_file");
        fileStatisticsEntity.setUploadDate(new Date(System.currentTimeMillis()));
        SortedSet<LineStatisticsResultEntity> lineSet = new TreeSet<>((Comparator<LineStatisticsResultEntity>) (o1, o2) -> 1);
        LineStatisticsResultEntity entity = new LineStatisticsResultEntity();
        entity.setLine("template is a word");
        entity.setShortestWord("a");
        entity.setLongestWord("template");
        entity.setAverageWordLength(4.4f);
        lineSet.add(entity);
        entity = new LineStatisticsResultEntity();
        entity.setLine("my name is denis");
        entity.setShortestWord("is");
        entity.setLongestWord("denis");
        entity.setAverageWordLength(3.7f);
        lineSet.add(entity);
        fileStatisticsEntity.setLineStatistics(lineSet);
        System.out.println(SEPARATOR);
        System.out.println("Entity to save: "+fileStatisticsEntity);
        FileStatisticsEntity fromDb = webStatisticsService.persistFileStatistics(fileStatisticsEntity);
        System.out.println(SEPARATOR);
        System.out.println("Saving to db returned: "+fromDb);
        assertNotNull(fromDb.getId());
        System.out.println(SEPARATOR);
        fileStatisticsEntity = webStatisticsService.getFileStatistics(fromDb.getId());
        System.out.println("Get from db returned: "+fileStatisticsEntity);
        System.out.println(SEPARATOR);
        System.out.println("Deleting returned: "+webStatisticsService.deleteFileStatistics(fileStatisticsEntity.getId()));
        fromDb = webStatisticsService.getFileStatistics(fileStatisticsEntity.getId());
        assertNull(fromDb);
        System.out.println(SEPARATOR);
        System.out.println("Asserting that there are no more of that file statistics in DB returned true");
    }

    @Test
    public void doPageTest(){
        Page<FileStatisticsEntity> page = webStatisticsService.getFileStatisticsList(0,10,"id", true);
        System.out.println(page.toString());
        assertNotNull(page);
        System.out.println(SEPARATOR);
        for (FileStatisticsEntity entity: page){
            System.out.println("Entity: id="+entity.getId()+" name="+entity.getFilename()+" uploaded="+entity.getUploadDate());
        }
    }
}