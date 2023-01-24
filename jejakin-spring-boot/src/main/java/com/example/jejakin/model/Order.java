package com.example.jejakin.model;

import com.mongodb.lang.NonNull;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")

public class Order {

    @Id
    private String id;
    @NotNull
    private String UserId;
    @NotNull
    private String ProductId;
    @NotNull
    private Integer Amount;
    @NotNull
    private Integer Status;

    public Order() {
    }

    public Order(String userId, String productId, Integer amount, Integer status) {
        this.UserId = userId;
        this.ProductId = productId;
        this.Amount = amount;
        this.Status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return UserId;
    }

    @NonNull
    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getProductId() {
        return ProductId;
    }

    @NonNull
    public void setProductId(String productId) {
        ProductId = productId;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }
}
