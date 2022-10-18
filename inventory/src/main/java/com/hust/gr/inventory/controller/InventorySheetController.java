package com.hust.gr.inventory.controller;

import com.hust.gr.inventory.model.dto.PageResponseDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetCreateDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetSearchDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetUpdateDTO;
import com.hust.gr.inventory.service.InventorySheetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/inventory-sheets")
@RequiredArgsConstructor
@Slf4j
public class InventorySheetController {
    private final InventorySheetService inventorySheetService;

    @PostMapping
    public ResponseEntity<InventorySheetDTO>
    createInventorySheet(@RequestBody @Validated InventorySheetCreateDTO createDTO) {
        log.info("Request to create inventory sheet");
        return ResponseEntity.ok(inventorySheetService.createInventorySheet(createDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventorySheetDTO> getInventorySheet(@PathVariable String id) {
        log.info("Request to get inventory sheet by id {}", id);
        return ResponseEntity.ok(inventorySheetService.getInventorySheetById(id));
    }

    @PutMapping
    public ResponseEntity<InventorySheetDTO>
    updateInventorySheet(@RequestBody @Validated InventorySheetUpdateDTO updateDTO) {
        log.info("Request to update inventory sheet by id {}", updateDTO.getId());
        return ResponseEntity.ok(inventorySheetService.updateInventorySheet(updateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInventorySheet(@PathVariable String id) {
        log.info("Request to delete inventory sheet by id {}", id);
        inventorySheetService.deleteInventorySheetById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<PageResponseDTO<InventorySheetDTO>>
    searchInventorySheet(@Validated InventorySheetSearchDTO searchDTO) {
        log.info("Request to search inventory sheet");
        return ResponseEntity.ok(inventorySheetService.searchInventorySheet(searchDTO));
    }
}
