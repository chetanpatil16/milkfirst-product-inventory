package com.milkfirst.controller;

import com.milkfirst.dto.InventoryDto;
import com.milkfirst.model.Inventory;
import com.milkfirst.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/addInventory")
    public ResponseEntity<Inventory> addInventory(@RequestBody InventoryDto dto){
        return new ResponseEntity<>(inventoryService.addInventory(dto), HttpStatus.CREATED);
    }

    @PutMapping("/updateQuantity/{id}")
    public ResponseEntity<Inventory> updateQuantity(@PathVariable("id") int id,@RequestBody InventoryDto dto){
        return ResponseEntity.ok(inventoryService.updateQuantity(id, dto));
    }

    @GetMapping("/ViewAllInventory")
    public ResponseEntity<List<Inventory>> viewAllInventory(){
        return ResponseEntity.ok(inventoryService.viewAll());
    }
}
