package com.hust.gr.inventory.adapter.impl;

import com.hust.gr.inventory.adapter.InventorySheetPort;
import com.hust.gr.inventory.mapper.InventorySheetMapper;
import com.hust.gr.inventory.model.collection.InventorySheetCollection;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetCreateDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetSearchDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetUpdateDTO;
import com.hust.gr.inventory.model.enum_.InventorySheetStatus;
import com.hust.gr.inventory.repository.InventorySheetCustomRepository;
import com.hust.gr.inventory.repository.InventorySheetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InventorySheetAdapter implements InventorySheetPort {
    private final InventorySheetRepository inventorySheetRepository;
    private final InventorySheetCustomRepository inventorySheetCustomRepository;
    private final InventorySheetMapper inventorySheetMapper;

    @Override
    public InventorySheetDTO createInventorySheet(InventorySheetCreateDTO createDTO) {
        InventorySheetCollection collection = inventorySheetMapper.toCollection(createDTO);
        collection.setDeleted(false);
        collection.setStatus(InventorySheetStatus.CHUA_PHE_DUYET);
        return inventorySheetMapper.toDTO(inventorySheetRepository.save(collection));
    }

    @Override
    public List<String> getAllInventorySheetCodes() {
        List<InventorySheetCollection> collections = inventorySheetRepository.findAllByDeleted(false);
        return collections.stream().map(InventorySheetCollection::getCode).collect(Collectors.toList());
    }

    @Override
    public InventorySheetDTO getInventorySheetById(String id) {
        InventorySheetCollection collection = inventorySheetRepository.findByIdAndDeleted(id, false);
        return inventorySheetMapper.toDTO(collection);
    }

    @Override
    public InventorySheetDTO updateInventorySheet(InventorySheetUpdateDTO updateDTO) {
        InventorySheetCollection oldCollection =
                inventorySheetRepository.findByIdAndDeleted(updateDTO.getId(), false);
        InventorySheetCollection newCollection = inventorySheetMapper.toCollection(updateDTO, oldCollection);
        return inventorySheetMapper.toDTO(inventorySheetRepository.save(newCollection));
    }

    @Override
    public void deleteInventorySheetById(String id) {
        InventorySheetCollection collection = inventorySheetRepository.findById(id).orElse(null);
        if (Objects.isNull(collection)) return;
        collection.setDeleted(true);
        inventorySheetRepository.save(collection);
    }

    @Override
    public List<InventorySheetDTO> searchInventorySheet(InventorySheetSearchDTO searchDTO) {
        List<InventorySheetCollection> collections = inventorySheetCustomRepository.findAll(searchDTO);
        return inventorySheetMapper.toDTOs(collections);
    }
}
