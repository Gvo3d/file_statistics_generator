package org.yakimovdenis.webserver.support;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.yakimovdenis.stats.LineStatisticsResult;
import org.yakimovdenis.stats.StatisticsResolver;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class FileStatisticsComposer {
    private static final Logger log = Logger.getLogger(FileStatisticsComposer.class);
    private final static int DEFAULT_SIZE = 50;
    private StatisticsResolver resolver = new StatisticsResolver();

    public List<FileStatisticsEntity> generateFileStatistics(MultipartFile[] files) {
        List<FileStatisticsEntity> result = new ArrayList<>(files.length);
        for (MultipartFile file : files) {
            FileStatisticsEntity entity = new FileStatisticsEntity();
            entity.setFilename(file.getOriginalFilename());
            entity.setUploadDate(new Date(System.currentTimeMillis()));
            Reader targetReader = null;
            List<String> lines = new ArrayList<>(DEFAULT_SIZE);
            try (BufferedReader reader = new BufferedReader(new StringReader(new String(file.getBytes())))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                log.error("Parsing went wrong with file: " + file.getOriginalFilename(), e);
            }
            entity.setLineStatisticsFromResult(resolver.getLineStatisticsForFile(lines.toArray(new String[lines.size()])));
            entity.setSize(entity.getLineStatistics().size());
            result.add(entity);
        }
        return result;
    }
}
