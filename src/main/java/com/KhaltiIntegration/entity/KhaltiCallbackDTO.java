package com.KhaltiIntegration.entity;

public class KhaltiCallbackDTO {

    private String pidx;
    private String transaction_id;
    private String tidx;
    private String txnId;
    private String amount;
    private String total_amount;
    private String mobile;
    private String status;
    private String purchase_order_id;
    private String purchase_order_name;

    public String getPidx() {
        return pidx;
    }

    public void setPidx(String pidx) {
        this.pidx = pidx;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTidx() {
        return tidx;
    }

    public void setTidx(String tidx) {
        this.tidx = tidx;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public KhaltiCallbackDTO() {
    }

    @Override
    public String toString() {
        return "KhaltiCallbackDTO{" +
                "pidx='" + pidx + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                ", tidx='" + tidx + '\'' +
                ", txnId='" + txnId + '\'' +
                ", amount='" + amount + '\'' +
                ", total_amount='" + total_amount + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status='" + status + '\'' +
                ", purchase_order_id='" + purchase_order_id + '\'' +
                ", purchase_order_name='" + purchase_order_name + '\'' +
                '}';
    }
}
