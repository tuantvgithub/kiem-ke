package com.hust.gr.inventory.model.collection.inventorysheet;

import com.hust.gr.inventory.model.enum_.InventoryMemberRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryMemberInfo {
    private String id;

    @NotBlank
    private String name;
    private String phone;
    private String email;

    @NotNull
    private InventoryMemberRole role;
}
