package com.milkfirst.repository;

import com.milkfirst.model.Inventory;
import com.milkfirst.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {


    Optional<Inventory> findByProduct(Product product);
}
