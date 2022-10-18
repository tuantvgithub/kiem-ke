package com.hust.gr.inventory.model.dto.inventoryminutes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryMinutesCreateDTO {
    @NotBlank
    private String inventorySheetId;
    @NotBlank
    private String minutesTemplateName;
}
