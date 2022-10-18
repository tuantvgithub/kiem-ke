package com.hust.gr.inventory.validation;

import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetSearchDTO;
import com.hust.gr.inventory.model.enum_.InventorySheetStatus;

import java.util.List;

public interface InventorySheetValidator {
    void validateUniqueCode(String code, List<String> existedCodes);
    void validateStartDateAndEndDate(String startTime, String endTime);
    void validateSearchDTONonNull(InventorySheetSearchDTO searchDTO);
    void validateResourceNotFound(InventorySheetDTO dto);
    void validateStatusToUpdate(InventorySheetStatus status);
    void validateStatusToDelete(InventorySheetStatus status);
}
