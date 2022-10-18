package com.hust.gr.inventory.model.dto.inventorysheet;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hust.gr.inventory.constant.Constant;
import com.hust.gr.inventory.model.collection.inventorysheet.InventoryMemberInfo;
import com.hust.gr.inventory.model.collection.inventorysheet.InventorySheetDetail;
import com.hust.gr.inventory.model.collection.inventorysheet.InventoryWarehouseInfo;
import com.hust.gr.inventory.model.enum_.InventorySheetStatus;
import com.hust.gr.inventory.model.enum_.InventorySheetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventorySheetDTO {
    private String id;
    private Boolean deleted;
    private String code;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE_FORMAT)
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE_FORMAT)
    private LocalDate endDate;

    private String purpose;
    private InventorySheetStatus status;
    private InventorySheetType type;
    private InventoryWarehouseInfo warehouse;
    private List<InventoryMemberInfo> members;
    private List<InventorySheetDetail> details;
}
