package com.hust.gr.inventory.model.dto.inventoryminutes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hust.gr.inventory.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryMinutesDTO {
    private String id;
    private String inventorySheetId;
    private String templateName;
    private String fileName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE_TIME_FORMAT)
    private LocalDateTime createdDate;
}
