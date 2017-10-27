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
        try {
            FileStatistics statistics = statisticsService.persistFileStatistics(getFileName("normal_test.txt"));
            assertNotNull(statistics);
            System.out.println(SEPARATOR);
            System.out.println(statistics);
        } catch (NoSuchFileException e) {
            e.printStackTrace();
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