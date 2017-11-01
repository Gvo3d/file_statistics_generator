package org.yakimovdenis.webserver.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yakimovdenis.webserver.dto.FileStatisticsPage;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;
import org.yakimovdenis.webserver.models.JacksonView;
import org.yakimovdenis.webserver.service.WebStatisticsService;

@RestController
public class RestFileController {

    @Autowired
    private WebStatisticsService webStatisticsService;

    @CrossOrigin("*")
    @JsonView(JacksonView.WithoutLineStatistics.class)
    @GetMapping(value = "/files/list", params = {"page", "quantity", "sort", "ascend"})
    public ResponseEntity<FileStatisticsPage> filesPage(
            @RequestParam("page") int page,
            @RequestParam("quantity") int quantity,
            @RequestParam("sort") String sort,
            @RequestParam("ascend") boolean ascend) {
        return new ResponseEntity<>(new FileStatisticsPage(webStatisticsService.getFileStatisticsList(page, quantity,sort,ascend)), HttpStatus.OK);
    }

    @CrossOrigin("*")
    @GetMapping(value = "/files/pagesCount", params = {"quantity"})
    public ResponseEntity<Integer> pagesCount(@RequestParam("quantity") int quantity) {
        return new ResponseEntity<>(webStatisticsService.getFileStatisticsPagesCount(quantity), HttpStatus.OK);
    }

    @CrossOrigin("*")
    @JsonView(JacksonView.FullStatistic.class)
    @GetMapping(value = "/files/one", params = {"id"})
    public ResponseEntity<FileStatisticsEntity> getOneFile(@RequestParam("id") int id) {
        return new ResponseEntity<>(webStatisticsService.getFileStatistics(id), HttpStatus.OK);
    }
}
