package com.KhaltiIntegration.entity;

import java.math.BigDecimal;

public class KhaltiRequest {

    private BigDecimal amount;
    private String purchase_order_id;
    private String purchase_order_name;

    public KhaltiRequest() {}

    public KhaltiRequest(BigDecimal amount, String purchase_order_id, String purchase_order_name) {
        this.amount = amount;
        this.purchase_order_id = purchase_order_id;
        this.purchase_order_name = purchase_order_name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPurchase_order_id() {
        return purchase_order_id;
    }

    public void setPurchase_order_id(String purchase_order_id) {
        this.purchase_order_id = purchase_order_id;
    }

    public String getPurchase_order_name() {
        return purchase_order_name;
    }

    public void setPurchase_order_name(String purchase_order_name) {
        this.purchase_order_name = purchase_order_name;
    }
}
