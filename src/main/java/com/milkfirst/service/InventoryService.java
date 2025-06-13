package com.milkfirst.service;

import com.milkfirst.dto.InventoryDto;
import com.milkfirst.exception.InventoryNotFoundException;
import com.milkfirst.exception.ProductNotFoundException;
import com.milkfirst.model.Inventory;
import com.milkfirst.model.Product;
import com.milkfirst.repository.InventoryRepository;
import com.milkfirst.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public Inventory addInventory(InventoryDto dto){
        Product product =productRepository.findById(dto.getProductId()).orElseThrow(() -> new ProductNotFoundException("Product Nit Found : "));

        Inventory inventory=new Inventory();
        inventory.setAvailableQuantity(dto.getAvailableQuantity());
        inventory.setLastUpdated(dto.getLastUpdated());
        inventory.setProduct(product);

        return inventoryRepository.save(inventory);

    }

    public Inventory updateQuantity(int id,InventoryDto dto){
        Inventory  inventory=inventoryRepository.findById(id).orElseThrow(() -> new InventoryNotFoundException("Product Not Found : "));

        inventory.setAvailableQuantity(dto.getAvailableQuantity());
        inventory.setLastUpdated(LocalDateTime.now());

        return inventoryRepository.save(inventory);

    }


    public List<Inventory> viewAll(){
        return inventoryRepository.findAll();
    }
}
