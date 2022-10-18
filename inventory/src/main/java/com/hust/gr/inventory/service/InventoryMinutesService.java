package com.hust.gr.inventory.service;

import com.hust.gr.inventory.model.dto.PageResponseDTO;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesCreateDTO;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesDTO;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesSearchDTO;

import java.io.IOException;

public interface InventoryMinutesService {
    InventoryMinutesDTO createInventoryMinutes(InventoryMinutesCreateDTO createDTO) throws IOException;
    InventoryMinutesDTO getInventoryMinutesById(String id);
    PageResponseDTO<InventoryMinutesDTO> searchInventoryMinutes(InventoryMinutesSearchDTO searchDTO);
    void deleteInventoryMinutesById(String id);
}
