package com.hust.gr.inventory.mapper;

import com.hust.gr.inventory.model.collection.InventoryMinutesCollection;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InventoryMinutesMapper {
    InventoryMinutesDTO toDTO(InventoryMinutesCollection minutesCollection);
}
