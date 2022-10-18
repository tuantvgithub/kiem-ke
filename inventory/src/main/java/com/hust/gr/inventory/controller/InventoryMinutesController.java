package com.hust.gr.inventory.controller;

import com.hust.gr.inventory.model.dto.PageResponseDTO;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesCreateDTO;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesDTO;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesSearchDTO;
import com.hust.gr.inventory.service.InventoryMinutesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/inventory-minutes")
@RequiredArgsConstructor
@Slf4j
public class InventoryMinutesController {
    private final InventoryMinutesService inventoryMinutesService;

    @PostMapping
    public ResponseEntity<InventoryMinutesDTO>
    createInventoryMinutes(@Validated @RequestBody InventoryMinutesCreateDTO createDTO) throws IOException {
        log.info("Request to create inventory minutes");
        return ResponseEntity.ok(inventoryMinutesService.createInventoryMinutes(createDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryMinutesDTO> getInventoryMinutes(@PathVariable String id) {
        log.info("Request to get inventory minutes by id {}", id);
        return ResponseEntity.ok(inventoryMinutesService.getInventoryMinutesById(id));
    }

    @GetMapping
    public ResponseEntity<PageResponseDTO<InventoryMinutesDTO>>
    searchInventoryMinutes(@Validated @RequestBody InventoryMinutesSearchDTO searchDTO) {
        log.info("Request to search inventory minutes");
        return ResponseEntity.ok(inventoryMinutesService.searchInventoryMinutes(searchDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInventoryMinutes(@PathVariable String id) {
        log.info("Request to delete inventory minutes");
        inventoryMinutesService.deleteInventoryMinutesById(id);
        return ResponseEntity.ok().build();
    }
}
