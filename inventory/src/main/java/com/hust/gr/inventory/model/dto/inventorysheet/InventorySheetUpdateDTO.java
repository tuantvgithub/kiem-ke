package com.hust.gr.inventory.model.dto.inventorysheet;

import com.hust.gr.inventory.model.collection.inventorysheet.InventoryMemberInfo;
import com.hust.gr.inventory.model.collection.inventorysheet.InventorySheetDetail;
import com.hust.gr.inventory.model.collection.inventorysheet.InventoryWarehouseInfo;
import com.hust.gr.inventory.model.enum_.InventorySheetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventorySheetUpdateDTO {
    @NotBlank
    private String id;
    @NotBlank
    private String startDate;
    @NotBlank
    private String endDate;

    private String purpose;

    @NotNull
    private InventorySheetType type;

    @Valid
    @NotEmpty
    private InventoryWarehouseInfo warehouse;

    @Valid
    @NotEmpty
    private List<InventoryMemberInfo> members;

    private List<InventorySheetDetail> details;
}
