package com.hust.gr.inventory.model.collection;

import com.hust.gr.inventory.model.collection.inventorysheet.InventoryMemberInfo;
import com.hust.gr.inventory.model.collection.inventorysheet.InventorySheetDetail;
import com.hust.gr.inventory.model.collection.inventorysheet.InventoryWarehouseInfo;
import com.hust.gr.inventory.model.enum_.InventorySheetStatus;
import com.hust.gr.inventory.model.enum_.InventorySheetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("inventory-sheet")
public class InventorySheetCollection extends BaseCollection {
    @Id
    private String id;
    private Boolean deleted;
    private String code;
    private LocalDate startDate;
    private LocalDate endDate;
    private String purpose;

    private InventorySheetStatus status;
    private InventorySheetType type;

    private InventoryWarehouseInfo warehouse;
    private List<InventoryMemberInfo> members;
    private List<InventorySheetDetail> details;
}
