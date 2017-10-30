package org.yakimovdenis.webserver.controllers;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yakimovdenis.webserver.dto.FileStatisticsList;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;
import org.yakimovdenis.webserver.models.JacksonView;
import org.yakimovdenis.webserver.service.WebStatisticsService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class RestFileController {

    @Autowired
    private WebStatisticsService webStatisticsService;

    @CrossOrigin("*")
    @JsonView(JacksonView.WithoutLineStatistics.class)
    @GetMapping(value = "/files/list", params = {"page", "quantity", "sort", "ascend"})
    public ResponseEntity<List<FileStatisticsEntity>> uploadFile(
            @RequestParam("page") int page,
            @RequestParam("quantity") int quantity,
            @RequestParam("sort") String sort,
            @RequestParam("ascend") boolean ascend) {
        return new ResponseEntity<>(webStatisticsService.getFileStatisticsList(page, quantity,sort,ascend).getContent(), HttpStatus.OK);
    }

    @CrossOrigin("*")
    @JsonView(JacksonView.FullStatistic.class)
    @GetMapping(value = "/files/one", params = {"id"})
    public ResponseEntity<FileStatisticsEntity> getOneFile(@RequestParam("id") int id) {
        return new ResponseEntity<>(webStatisticsService.getFileStatistics(id), HttpStatus.OK);
    }
}
