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
    private String userId;
    @NotNull
    private String productId;
    @NotNull
    private Integer amount;
    @NotNull
    private Integer status;

    public Order() {
    }

    public Order(String userId, String productId, Integer amount, Integer status) {
        this.userId = userId;
        this.productId = productId;
        this.amount = amount;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    @NonNull
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    @NonNull
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
