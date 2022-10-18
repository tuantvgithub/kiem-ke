package com.hust.gr.inventory.validation.impl;

import com.hust.gr.inventory.constant.Constant;
import com.hust.gr.inventory.exception.BadRequestException;
import com.hust.gr.inventory.exception.PermissionDeniedException;
import com.hust.gr.inventory.exception.ResourceNotFoundException;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetDTO;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetSearchDTO;
import com.hust.gr.inventory.model.enum_.InventorySheetStatus;
import com.hust.gr.inventory.utils.DateUtils;
import com.hust.gr.inventory.validation.InventorySheetValidator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class InventorySheetValidatorImpl implements InventorySheetValidator {
    @Override
    public void validateUniqueCode(String code, List<String> existedCodes) {
        if (existedCodes.contains(code))
            throw new BadRequestException("code is not valid. Already existed");
    }

    @Override
    public void validateStartDateAndEndDate(String startDate, String endDate) {
        if (DateUtils.isBefore(startDate, endDate, Constant.DATE_FORMAT))
            throw new BadRequestException("endTime is not valid. Must be after startTime");
    }

    @Override
    public void validateSearchDTONonNull(InventorySheetSearchDTO searchDTO) {
        if (Objects.isNull(searchDTO))
            throw new BadRequestException("searchDTO is required");
    }

    @Override
    public void validateResourceNotFound(InventorySheetDTO dto) {
        if (Objects.isNull(dto))
            throw new ResourceNotFoundException("Inventory sheet is not existed");
    }

    @Override
    public void validateStatusToUpdate(InventorySheetStatus status) {
        if (status.equals(InventorySheetStatus.DA_PHE_DUYET) ||
                status.equals(InventorySheetStatus.HOAN_THANH)) {
            throw new PermissionDeniedException("Permission denied.");
        }
    }

    @Override
    public void validateStatusToDelete(InventorySheetStatus status) {
        if (!status.equals(InventorySheetStatus.CHUA_PHE_DUYET))
            throw new PermissionDeniedException("Permission denied.");
    }
}
