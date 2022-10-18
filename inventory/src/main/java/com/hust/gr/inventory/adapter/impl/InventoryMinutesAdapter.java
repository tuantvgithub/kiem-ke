package com.hust.gr.inventory.adapter.impl;

import com.hust.gr.inventory.adapter.InventoryMinutesPort;
import com.hust.gr.inventory.mapper.InventoryMinutesMapper;
import com.hust.gr.inventory.model.collection.InventoryMinutesCollection;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesCreateDTO;
import com.hust.gr.inventory.model.dto.inventoryminutes.InventoryMinutesDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetDTO;
import com.hust.gr.inventory.repository.InventoryMinutesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class InventoryMinutesAdapter implements InventoryMinutesPort {
    private final InventoryMinutesRepository inventoryMinutesRepository;
    private final InventoryMinutesMapper inventoryMinutesMapper;

    @Override
    public InventoryMinutesDTO createInventoryMinutes(InventoryMinutesCreateDTO createDTO,
                                                      InventorySheetDTO sheetDTO,
                                                      ResponseEntity<Resource> fileResource) throws IOException {
        final Resource body = fileResource.getBody();
        if (Objects.isNull(body)) return null;
        final String fileName = saveMinutesFile(sheetDTO, body.getFile());

        InventoryMinutesCollection minutesCollection = new InventoryMinutesCollection();
        minutesCollection.setInventorySheetId(sheetDTO.getId());
        minutesCollection.setTemplateName(createDTO.getMinutesTemplateName());
        minutesCollection.setFileName(fileName);

        return inventoryMinutesMapper.toDTO(inventoryMinutesRepository.save(minutesCollection));
    }

    private String saveMinutesFile(InventorySheetDTO sheetDTO, File templateFile) {
        // TODO document why this method is empty
        return null;
    }

    @Override
    public InventoryMinutesDTO getInventoryMinutesById(String id) {
        InventoryMinutesCollection collection = inventoryMinutesRepository.findById(id).orElse(null);
        return inventoryMinutesMapper.toDTO(collection);
    }

    @Override
    public void deleteInventoryMinutesById(String id) {
        inventoryMinutesRepository.deleteById(id);
    }
}
