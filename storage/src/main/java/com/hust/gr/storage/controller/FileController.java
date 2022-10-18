package com.hust.gr.storage.controller;

import com.hust.gr.storage.service.FileService;
import com.hust.gr.storage.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/files")
@RequiredArgsConstructor
@Slf4j
public class FileController {
    private final FileService fileService;

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestPart MultipartFile file) {
        log.info("Request to upload file");
        return ResponseEntity.ok(fileService.uploadFile(file));
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) throws HttpMediaTypeNotSupportedException {
        log.info("Request to get file name {}", fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(CommonUtils.getMediaTypeByFileName(fileName));
        headers.setContentDispositionFormData(fileName, fileName);
        return ResponseEntity.ok().headers(headers).body(fileService.getFile(fileName));
    }
}
