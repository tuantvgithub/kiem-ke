package com.hust.gr.inventory.validation;

import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesDTO;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface InventoryMinutesValidator {
    void validateMinutesTemplate(ResponseEntity<Resource> fileResource);
    void validateResourceNotFound(InventoryMinutesDTO dto);
}
