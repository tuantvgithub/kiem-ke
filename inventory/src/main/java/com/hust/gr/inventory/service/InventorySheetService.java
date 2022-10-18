package com.hust.gr.inventory.service;

import com.hust.gr.inventory.model.dto.PageResponseDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetCreateDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetSearchDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetUpdateDTO;

public interface InventorySheetService {
    InventorySheetDTO createInventorySheet(InventorySheetCreateDTO createDTO);
    InventorySheetDTO getInventorySheetById(String id);
    InventorySheetDTO updateInventorySheet(InventorySheetUpdateDTO updateDTO);
    void deleteInventorySheetById(String id);
    PageResponseDTO<InventorySheetDTO> searchInventorySheet(InventorySheetSearchDTO searchDTO);
}
