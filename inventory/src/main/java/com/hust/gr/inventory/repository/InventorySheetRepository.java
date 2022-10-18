package com.hust.gr.inventory.repository;

import com.hust.gr.inventory.model.collection.InventorySheetCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventorySheetRepository extends MongoRepository<InventorySheetCollection, String> {
    InventorySheetCollection findByIdAndDeleted(String id, Boolean deleted);
    List<InventorySheetCollection> findAllByDeleted(Boolean deleted);
}
