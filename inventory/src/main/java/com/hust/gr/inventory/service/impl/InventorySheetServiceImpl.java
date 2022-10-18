package com.hust.gr.inventory.service.impl;

import com.hust.gr.inventory.adapter.InventorySheetPort;
import com.hust.gr.inventory.model.dto.PageResponseDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetCreateDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetSearchDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetUpdateDTO;
import com.hust.gr.inventory.model.dto.page.MetaDTO;
import com.hust.gr.inventory.service.InventorySheetService;
import com.hust.gr.inventory.validation.InventorySheetValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InventorySheetServiceImpl implements InventorySheetService {
    private final InventorySheetPort inventorySheetPort;
    private final InventorySheetValidator inventorySheetValidator;

    @Value("${app.page.default-limit}")
    private Integer defaultLimit;
    @Value("${app.page.default-skip}")
    private Integer defaultSkip;

    @Override
    @Transactional
    public InventorySheetDTO createInventorySheet(InventorySheetCreateDTO createDTO) {
        inventorySheetValidator.validateUniqueCode(createDTO.getCode(),
                inventorySheetPort.getAllInventorySheetCodes());
        inventorySheetValidator.validateStartDateAndEndDate(createDTO.getStartDate(), createDTO.getEndDate());
        return inventorySheetPort.createInventorySheet(createDTO);
    }

    @Override
    public InventorySheetDTO getInventorySheetById(String id) {
        InventorySheetDTO dto = inventorySheetPort.getInventorySheetById(id);
        inventorySheetValidator.validateResourceNotFound(dto);
        return dto;
    }

    @Override
    @Transactional
    public InventorySheetDTO updateInventorySheet(InventorySheetUpdateDTO updateDTO) {
        inventorySheetValidator.validateStartDateAndEndDate(updateDTO.getStartDate(), updateDTO.getEndDate());

        InventorySheetDTO dto = inventorySheetPort.getInventorySheetById(updateDTO.getId());
        inventorySheetValidator.validateResourceNotFound(dto);
        inventorySheetValidator.validateStatusToUpdate(dto.getStatus());

        return inventorySheetPort.updateInventorySheet(updateDTO);
    }

    @Override
    @Transactional
    public void deleteInventorySheetById(String id) {
        InventorySheetDTO dto = inventorySheetPort.getInventorySheetById(id);
        inventorySheetValidator.validateStatusToDelete(dto.getStatus());
        inventorySheetPort.deleteInventorySheetById(id);
    }

    @Override
    public PageResponseDTO<InventorySheetDTO> searchInventorySheet(InventorySheetSearchDTO searchDTO) {
        inventorySheetValidator.validateSearchDTONonNull(searchDTO);
        if (Objects.isNull(searchDTO.getLimit()))
            searchDTO.setLimit(defaultLimit);
        if (Objects.isNull(searchDTO.getSkip()))
            searchDTO.setSkip(defaultSkip);

        final PageResponseDTO<InventorySheetDTO> page = new PageResponseDTO<>();
        page.setData(inventorySheetPort.searchInventorySheet(searchDTO));
        page.setMeta(new MetaDTO(searchDTO.getLimit(), searchDTO.getSkip()));

        return page;
    }
}
