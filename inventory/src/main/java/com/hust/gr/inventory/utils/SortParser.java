package com.hust.gr.inventory.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Sort;

@UtilityClass
public class SortParser {
    private static final String SEPARATED = ",";
    private static final String DEFAULT_SORT_BY_MODIFIED_DATE = "modifiedDate";
    private static final String DESCENDING_SIGN = "-";

    public Sort parse(String sortRequest) {
        if (StringUtils.isBlank(sortRequest))
            return defaultSort();

        Sort sort = Sort.unsorted();
        final String[] sortProperties = sortRequest.split(SEPARATED);
        for (String sortProperty : sortProperties) {
            if (StringUtils.isBlank(sortProperty))
                continue;
            if (sortProperty.startsWith(DESCENDING_SIGN))
                sort = sort.and(Sort.by(sortProperty.substring(1)).descending());
            else
                sort = sort.and(Sort.by(sortProperty.substring(1)).ascending());
        }

        return sort;
    }

    public Sort defaultSort() {
        return Sort.by(DEFAULT_SORT_BY_MODIFIED_DATE).descending();
    }
}
