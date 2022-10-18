package com.hust.gr.inventory.model.collection.inventorysheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryWarehouseInfo {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
}
