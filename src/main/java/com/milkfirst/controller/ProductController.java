package com.milkfirst.controller;

import com.milkfirst.dto.ProductDto;
import com.milkfirst.model.Product;
import com.milkfirst.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody @Valid ProductDto dto){
        return new ResponseEntity(productService.addProduct(dto), HttpStatus.CREATED);
    }

    @GetMapping("/GetAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());

    }

    @GetMapping("/GetProductById/{id}")
    public ResponseEntity<Product> getByID(@PathVariable("id") int id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @PutMapping("/UpdateProduct/{id}")
    public ResponseEntity<Product> updateProductDetails(@RequestBody ProductDto dto, @PathVariable("id") int id){
        return ResponseEntity.ok(productService.updateProductDetails(dto,id));

    }

    @DeleteMapping("/DeleteProductById/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product Delete Successfully");
    }
}
