package com.hust.gr.inventory.model.dto.inventorysheet;

import com.hust.gr.inventory.model.collection.inventorysheet.InventoryMemberInfo;
import com.hust.gr.inventory.model.collection.inventorysheet.InventorySheetDetail;
import com.hust.gr.inventory.model.collection.inventorysheet.InventoryWarehouseInfo;
import com.hust.gr.inventory.model.enum_.InventorySheetType;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class InventorySheetCreateDTO {
    @NotBlank
    private String code;
    @NotBlank
    private String startDate;
    @NotBlank
    private String endDate;

    private String purpose;

    @NotNull
    private InventorySheetType type;

    @Valid
    @NotNull
    private InventoryWarehouseInfo warehouse;

    @Valid
    @NotEmpty
    private List<InventoryMemberInfo> members;

    private List<InventorySheetDetail> details;
}
