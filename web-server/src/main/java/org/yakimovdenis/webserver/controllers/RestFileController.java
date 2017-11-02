package org.yakimovdenis.webserver.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yakimovdenis.webserver.dto.FileStatisticsPage;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;
import org.yakimovdenis.webserver.models.JacksonView;
import org.yakimovdenis.webserver.service.WebStatisticsService;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
public class RestFileController {
    private static final Logger log = Logger.getLogger(RestFileController.class);
    private final static String EMPTY_FILE = "File is empty, please select a file!";
    private final static String SAVE_ERROR = "Can't save files ";

    @Autowired
    private WebStatisticsService webStatisticsService;

    @JsonView(JacksonView.WithoutLineStatistics.class)
    @GetMapping(value = "/files/list", params = {"page", "quantity", "sort", "ascend"})
    public ResponseEntity<FileStatisticsPage> filesPage(
            @RequestParam("page") int page,
            @RequestParam("quantity") int quantity,
            @RequestParam("sort") String sort,
            @RequestParam("ascend") boolean ascend) {
        return new ResponseEntity<>(new FileStatisticsPage(webStatisticsService.getFileStatisticsList(page, quantity, sort, ascend)), HttpStatus.OK);
    }

    @PostMapping("/files/upload")
    public ResponseEntity<?> uploadFileMulti(@RequestParam("files") MultipartFile[] uploadfiles) {
        String uploadedFileName = Arrays.stream(uploadfiles).map(MultipartFile::getOriginalFilename)
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
        if (StringUtils.isEmpty(uploadedFileName)) {
            return new ResponseEntity<>(EMPTY_FILE, HttpStatus.NO_CONTENT);
        }
        try {
            webStatisticsService.persistFileStatistics(uploadfiles);
        } catch (Exception e) {
            log.error(SAVE_ERROR, e);
            return new ResponseEntity<>(SAVE_ERROR + e.getMessage() != null ? e : "", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully uploaded - " + uploadedFileName, HttpStatus.OK);
    }

    @JsonView(JacksonView.FullStatistic.class)
    @GetMapping(value = "/files/one", params = {"id"})
    public ResponseEntity<FileStatisticsEntity> getOneFile(@RequestParam("id") int id) {
        return new ResponseEntity<>(webStatisticsService.getFileStatistics(id), HttpStatus.OK);
    }
}
