package com.hust.gr.inventory.adapter;

import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesCreateDTO;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetDTO;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface InventoryMinutesPort {
    InventoryMinutesDTO createInventoryMinutes(InventoryMinutesCreateDTO createDTO,
                                               InventorySheetDTO sheetDTO,
                                               ResponseEntity<Resource> fileResource) throws IOException;
    InventoryMinutesDTO getInventoryMinutesById(String id);
    void deleteInventoryMinutesById(String id);
}
