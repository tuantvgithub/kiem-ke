package com.hust.gr.inventory.mapper;

import com.hust.gr.inventory.utils.DateUtils;
import com.hust.gr.inventory.constant.Constant;
import com.hust.gr.inventory.model.collection.InventorySheetCollection;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetCreateDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InventorySheetMapper {
    InventorySheetDTO toDTO(InventorySheetCollection collection);
    List<InventorySheetDTO> toDTOs(List<InventorySheetCollection> collections);

    @Mapping(target = "startDate", source = "startDate", qualifiedByName = "toLocalDate")
    @Mapping(target = "endDate", source = "endDate", qualifiedByName = "toLocalDate")
    InventorySheetCollection toCollection(InventorySheetCreateDTO createDTO);

    @Mapping(target = "startDate", source = "updateDTO.startDate", qualifiedByName = "toLocalDate")
    @Mapping(target = "endDate", source = "updateDTO.endDate", qualifiedByName = "toLocalDate")
    @Mapping(target = "id", source = "updateDTO.id")
    @Mapping(target = "purpose", source = "updateDTO.purpose")
    @Mapping(target = "type", source = "updateDTO.type")
    @Mapping(target = "warehouse", source = "updateDTO.warehouse")
    @Mapping(target = "members", source = "updateDTO.members")
    @Mapping(target = "details", source = "updateDTO.details")
    @Mapping(target = "deleted", source = "collection.deleted")
    @Mapping(target = "code", source = "collection.code")
    @Mapping(target = "status", source = "collection.status")
    InventorySheetCollection toCollection(InventorySheetUpdateDTO updateDTO,
                                          InventorySheetCollection collection);

    @Named("toLocalDate")
    static LocalDate toLocalDate(String date) {
        return DateUtils.toLocalDate(date, Constant.DATE_FORMAT);
    }
}
