package org.yakimovdenis.stats;

import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.*;

public class StatisticsFileReader {
    private static final Logger log = Logger.getLogger(StatisticsFileReader.class);
    private StatisticsResolver resolver;

    public StatisticsFileReader() {
        this.resolver = new StatisticsResolver();
    }

    public List<LineStatisticsResult> resolveFile(File file) throws NoSuchFileException {
        try {
            String[] lines = Files.lines(file.toPath()).toArray(String[]::new);
            return resolver.getLineStatisticsForFile(lines);
        } catch (NoSuchFileException e) {
            log.error("Can't read file with name: "+file.getAbsolutePath(), e);
            throw e;
        } catch (IOException e) {
            log.error("Can't open file with name: "+file.getAbsolutePath(), e);
        }
        return Collections.emptyList();
    }
}
