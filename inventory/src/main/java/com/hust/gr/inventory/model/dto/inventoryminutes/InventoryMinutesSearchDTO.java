package com.hust.gr.inventory.model.dto.inventoryminutes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryMinutesSearchDTO {
    private Integer skip;
    private Integer limit;
    private String fileName;
}
