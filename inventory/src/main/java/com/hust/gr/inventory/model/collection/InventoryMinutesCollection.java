package com.hust.gr.inventory.model.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("inventory-minutes")
public class InventoryMinutesCollection extends BaseCollection {
    @Id
    private String id;
    private String inventorySheetId;
    private String templateName;
    private String fileName;
}
