package com.hust.gr.inventory.repository;

import com.hust.gr.inventory.model.collection.InventoryMinutesCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryMinutesRepository extends MongoRepository<InventoryMinutesCollection, String> {

}
