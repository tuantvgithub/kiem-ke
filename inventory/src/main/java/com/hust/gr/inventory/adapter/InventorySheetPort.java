package com.hust.gr.inventory.adapter;

import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetCreateDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetSearchDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetUpdateDTO;

import java.util.List;

public interface InventorySheetPort {
    InventorySheetDTO createInventorySheet(InventorySheetCreateDTO createDTO);
    List<String> getAllInventorySheetCodes();
    InventorySheetDTO getInventorySheetById(String id);
    InventorySheetDTO updateInventorySheet(InventorySheetUpdateDTO updateDTO);
    void deleteInventorySheetById(String id);
    List<InventorySheetDTO> searchInventorySheet(InventorySheetSearchDTO searchDTO);
}
