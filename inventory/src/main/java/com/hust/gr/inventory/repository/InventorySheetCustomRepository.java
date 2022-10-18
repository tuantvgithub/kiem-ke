package com.hust.gr.inventory.repository;

import com.hust.gr.inventory.model.collection.InventorySheetCollection;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetSearchDTO;

import java.util.List;

public interface InventorySheetCustomRepository {
    List<InventorySheetCollection> findAll(InventorySheetSearchDTO searchDTO);
}
