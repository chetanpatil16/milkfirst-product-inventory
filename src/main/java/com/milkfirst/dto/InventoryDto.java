package com.milkfirst.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class InventoryDto {

    @Min(0)
    @NotNull
    private int availableQuantity;

    private LocalDateTime lastUpdated;

    private int productId;

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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "InventoryDto{" +
                "availableQuantity=" + availableQuantity +
                ", lastUpdated=" + lastUpdated +
                ", productId=" + productId +
                '}';
    }
}
