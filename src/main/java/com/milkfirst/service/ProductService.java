package com.milkfirst.service;

import com.milkfirst.dto.ProductDto;
import com.milkfirst.exception.ProductDeletionException;
import com.milkfirst.exception.ProductNotFoundException;
import com.milkfirst.model.Product;
import com.milkfirst.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        product.setUnit(dto.getUnit());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getById(int id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found :" + id));
    }

    public Product updateProductDetails(ProductDto dto, int id){
        Product product=productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found :" + id));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        product.setUnit(dto.getUnit());
        return productRepository.save(product);
    }

    public int deleteProduct(int id){
        productRepository.findById(id).orElseThrow(() -> new ProductDeletionException("Product Not Found" + id));
            productRepository.deleteById(id);
            return 1;
    }
}
