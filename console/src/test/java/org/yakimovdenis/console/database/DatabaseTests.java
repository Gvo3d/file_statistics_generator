package org.yakimovdenis.console.database;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.yakimovdenis.console.model.FileStatistics;
import org.yakimovdenis.console.service.StatisticsService;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.*;

import static org.junit.Assert.*;

public class DatabaseTests extends AbstractDatabaseTest {

    @Autowired
    private StatisticsService statisticsService;

    @Test
    public void testFile(){
        String fileName = "normal_test.txt";
        Integer statisticsId = null;
        try {
            FileStatistics statistics = statisticsService.persistFileStatistics(getFileName(fileName));
            assertNotNull(statistics);
            System.out.println(SEPARATOR);
            System.out.println("WAS SAVED FROM FILE "+fileName+" TO DATABASE:");
            System.out.println(statistics);
            statisticsId = statistics.getId();
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        }
        FileStatistics statistics = statisticsService.getStatisticsForFile(statisticsId);
        assertNotNull(statistics);
        System.out.println(SEPARATOR);
        System.out.println("READING FROM DATABASE:");
        System.out.println(statistics);
        System.out.println(SEPARATOR);
        System.out.println("DELETING FILE STATISTIC FROM DATABASE:");
        statisticsService.deleteFileStatistics(statisticsId);
        statistics = statisticsService.getStatisticsForFile(statisticsId);
        assertNull(statistics);
        System.out.println("Object was succesfully deleted");
    }

    @Test
    public void doTestGetIdsMethod(){
        List<FileStatistics> statistics = statisticsService.getFileNameAndIds();
        System.out.println(SEPARATOR);
        for (FileStatistics stat: statistics){
            System.out.println("File: id="+stat.getId()+", uplodeaded="+stat.getFileUploadDate()+", name="+stat.getFileName());
        }
    }


    private String getFileName(String prefix){
        ClassLoader classLoader = getClass().getClassLoader();
        File file;
        try {
            file = new File(classLoader.getResource(prefix).getFile());
        } catch (NullPointerException e) {
            file = new File(prefix);
        }
        return file.getAbsolutePath();
    }
}