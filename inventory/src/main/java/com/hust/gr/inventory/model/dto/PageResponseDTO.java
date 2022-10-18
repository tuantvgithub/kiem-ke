package com.hust.gr.inventory.model.dto;

import com.hust.gr.inventory.model.dto.page.MetaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDTO<T> {
    private List<T> data;
    private MetaDTO meta;
}
