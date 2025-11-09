package com.KhaltiIntegration.entity;

public class KhaltiResponse {

    private String pidx;
    private String payment_url;
    private String expires_at;
    private String expires_in;

    public KhaltiResponse() {
    }

    public String getPidx() {
        return pidx;
    }

    public void setPidx(String pidx) {
        this.pidx = pidx;
    }

    public String getPayment_url() {
        return payment_url;
    }

    public void setPayment_url(String payment_url) {
        this.payment_url = payment_url;
    }

    public String getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "KhaltiResponse{" +
                "pidx='" + pidx + '\'' +
                ", payment_url='" + payment_url + '\'' +
                ", expires_at='" + expires_at + '\'' +
                ", expires_in='" + expires_in + '\'' +
                '}';
    }
}
