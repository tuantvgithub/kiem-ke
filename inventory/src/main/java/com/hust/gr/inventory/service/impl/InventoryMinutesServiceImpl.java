package com.hust.gr.inventory.service.impl;

import com.hust.gr.inventory.adapter.InventoryMinutesPort;
import com.hust.gr.inventory.adapter.InventorySheetPort;
import com.hust.gr.inventory.adapter.StorageAPIPort;
import com.hust.gr.inventory.exception.BadRequestException;
import com.hust.gr.inventory.model.dto.PageResponseDTO;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesCreateDTO;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesDTO;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesSearchDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetDTO;
import com.hust.gr.inventory.service.InventoryMinutesService;
import com.hust.gr.inventory.validation.InventoryMinutesValidator;
import com.hust.gr.inventory.validation.InventorySheetValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InventoryMinutesServiceImpl implements InventoryMinutesService {
    private final InventoryMinutesValidator inventoryMinutesValidator;
    private final InventorySheetValidator inventorySheetValidator;
    private final InventorySheetPort inventorySheetPort;
    private final InventoryMinutesPort inventoryMinutesPort;
    private final StorageAPIPort storageAPIPort;

    @Override
    @Transactional
    public InventoryMinutesDTO createInventoryMinutes(InventoryMinutesCreateDTO createDTO) throws IOException {
        InventorySheetDTO sheetDTO = inventorySheetPort.getInventorySheetById(createDTO.getInventorySheetId());
        inventorySheetValidator.validateResourceNotFound(sheetDTO);
        ResponseEntity<Resource> fileResource = storageAPIPort.getFile(createDTO.getMinutesTemplateName());
        inventoryMinutesValidator.validateMinutesTemplate(fileResource);

        InventoryMinutesDTO minutesDTO = inventoryMinutesPort.createInventoryMinutes(createDTO, sheetDTO, fileResource);
        if (Objects.isNull(minutesDTO))
            throw new BadRequestException();
        return minutesDTO;
    }

    @Override
    public InventoryMinutesDTO getInventoryMinutesById(String id) {
        InventoryMinutesDTO dto = inventoryMinutesPort.getInventoryMinutesById(id);
        inventoryMinutesValidator.validateResourceNotFound(dto);
        return dto;
    }

    @Override
    public PageResponseDTO<InventoryMinutesDTO> searchInventoryMinutes(InventoryMinutesSearchDTO searchDTO) {
        return null;
    }

    @Override
    @Transactional
    public void deleteInventoryMinutesById(String id) {
        inventoryMinutesPort.deleteInventoryMinutesById(id);
        // TODO delete file in storage
    }
}
