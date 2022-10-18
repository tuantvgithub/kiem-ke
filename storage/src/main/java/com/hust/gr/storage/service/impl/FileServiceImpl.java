package com.hust.gr.storage.service.impl;

import com.hust.gr.storage.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    @Override
    public String uploadFile(MultipartFile file) {
        return null;
    }

    @Override
    public Resource getFile(String fileName) {
        return null;
    }
}
