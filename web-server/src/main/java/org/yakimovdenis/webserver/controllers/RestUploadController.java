package org.yakimovdenis.webserver.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.yakimovdenis.webserver.models.UploadModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestUploadController {
    private static final Logger log = Logger.getLogger(RestUploadController.class);
    private final static String EMPTY_FILE = "File is empty, please select a file!";

    private static String UPLOADED_FOLDER = "/files/";

    @PostMapping("/api/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile uploadfile) {
        if (uploadfile.isEmpty()) {
            return new ResponseEntity<>(EMPTY_FILE, HttpStatus.NO_CONTENT);
        }
        try {
            saveUploadedFiles(Arrays.asList(uploadfile));
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully uploaded - " + uploadfile.getOriginalFilename(), HttpStatus.OK);
    }

    @PostMapping("/api/upload/multi")
    public ResponseEntity<?> uploadFileMulti(@RequestParam("extraField") String extraField, @RequestParam("files") MultipartFile[] uploadfiles) {
        String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
        if (StringUtils.isEmpty(uploadedFileName)) {
            return new ResponseEntity<>(EMPTY_FILE, HttpStatus.NO_CONTENT);
        }
        try {
            saveUploadedFiles(Arrays.asList(uploadfiles));
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully uploaded - " + uploadedFileName, HttpStatus.OK);

    }

    @PostMapping("/api/upload/multi/model")
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute UploadModel model) {
        try {
            saveUploadedFiles(Arrays.asList(model.getFiles()));
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully uploaded!", HttpStatus.OK);

    }

    private void saveUploadedFiles(List<MultipartFile> files) throws IOException {
        for (MultipartFile file : files) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        }
    }
}
