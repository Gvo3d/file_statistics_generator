package org.yakimovdenis.webserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;
import org.yakimovdenis.webserver.service.WebStatisticsService;

import java.io.IOException;
import java.util.Arrays;

@RestController
public class RestFileContoller {

    @Autowired
    private WebStatisticsService webStatisticsService;

    @GetMapping(name = "/files/list", params = {"page", "quantity", "sort", "ascend"})
    public ResponseEntity<Page<FileStatisticsEntity>> uploadFile(
            @RequestParam("page") int page,
            @RequestParam("quantity") int quantity,
            @RequestParam("sort") String sort,
            @RequestParam("ascend") boolean ascend) {
        return new ResponseEntity<>(webStatisticsService.getFileStatisticsList(page, quantity,sort,ascend), HttpStatus.OK);
    }
}
