package com.hust.gr.inventory.adapter;

import com.hust.gr.inventory.constant.Constant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = Constant.Microservice.Storage.NAME, url = Constant.Microservice.Storage.END_POINT)
public interface StorageAPIPort {
    @GetMapping(Constant.Microservice.Storage.GET_FILE_API_URI + "/{fileName}")
    ResponseEntity<Resource> getFile(@PathVariable String fileName);
}
