package com.hust.gr.inventory.model.dto.inventorysheet;

import com.hust.gr.inventory.model.enum_.InventorySheetStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventorySheetSearchDTO {
    private Integer skip;
    private Integer limit;
    private String sort;

    private String inventorySheetCode;
    private InventorySheetStatus inventorySheetStatus;
}
