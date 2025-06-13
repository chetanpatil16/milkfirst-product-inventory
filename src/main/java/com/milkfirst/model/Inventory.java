package com.milkfirst.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;

    @Min(0)
    private int availableQuantity;

    private LocalDateTime lastUpdated;

    @OneToOne
    @JoinColumn(name= "product_Id")
    @NotNull
    private Product product;

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public @Min(0) int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(@Min(0) int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", availableQuantity=" + availableQuantity +
                ", lastUpdated=" + lastUpdated +
                ", product=" + product +
                '}';
    }
}
