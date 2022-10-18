package com.hust.gr.inventory.validation.impl;

import com.hust.gr.inventory.exception.BadRequestException;
import com.hust.gr.inventory.exception.ResourceNotFoundException;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesDTO;
import com.hust.gr.inventory.validation.InventoryMinutesValidator;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class InventoryMinutesValidatorImpl implements InventoryMinutesValidator {
    @Override
    public void validateMinutesTemplate(ResponseEntity<Resource> fileResource) {
        if (!fileResource.getStatusCode().equals(HttpStatus.OK) ||
                Objects.isNull(fileResource.getBody())) {
            throw new BadRequestException("minutesTemplateName is not valid");
        }
    }

    @Override
    public void validateResourceNotFound(InventoryMinutesDTO dto) {
        if (Objects.isNull(dto))
            throw new ResourceNotFoundException("Inventory minutes is not exists");
    }
}
