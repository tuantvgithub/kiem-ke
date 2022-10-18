package com.hust.gr.inventory.repository.impl;

import com.hust.gr.inventory.constant.Constant;
import com.hust.gr.inventory.model.collection.InventorySheetCollection;
import com.hust.gr.inventory.model.dto.inventorysheet.InventorySheetSearchDTO;
import com.hust.gr.inventory.repository.InventorySheetCustomRepository;
import com.hust.gr.inventory.utils.SortParser;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class InventorySheetCustomRepoImpl implements InventorySheetCustomRepository {
    private final MongoTemplate mongoTemplate;

    @Override
    public List<InventorySheetCollection> findAll(InventorySheetSearchDTO searchDTO) {
        final Query query = new Query().with(SortParser.parse(searchDTO.getSort()));
        if (Objects.nonNull(searchDTO.getSkip()))
            query.skip(searchDTO.getSkip());
        if (Objects.nonNull(searchDTO.getLimit()))
            query.limit(searchDTO.getLimit());

        final List<Criteria> criteria = new ArrayList<>();
        if (StringUtils.isNotBlank(searchDTO.getInventorySheetCode())) {
            criteria.add(Criteria.where(Constant.InventorySheet.KEY_FILTER_BY_CODE)
                    .is(searchDTO.getInventorySheetCode()));
        }
        if (Objects.nonNull(searchDTO.getInventorySheetStatus())) {
            criteria.add(Criteria.where(Constant.InventorySheet.KEY_FILTER_BY_STATUS)
                    .is(searchDTO.getInventorySheetStatus()));
        }

        if (!CollectionUtils.isEmpty(criteria))
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));

        return mongoTemplate.find(query, InventorySheetCollection.class);
    }
}
