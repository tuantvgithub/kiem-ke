package com.hust.gr.inventory.model.collection.inventorysheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventorySheetDetail {
    private String goodsCode;
    private String goodsName;
    private String unit;
    private String placement;
    
    private Integer quantity;
    private Integer actualQuantity;
    private Integer difference;
    
    private String solution;
}
