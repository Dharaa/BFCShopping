package com.example.bfcfashion.module.model;

public class DeliveredItem {
    private String orderNo;
    private String date;
    private String trackingNo;
    private String quantity;
    private String totalAmount;
    private String status;

    public DeliveredItem(String orderNo, String date, String trackingNo, String quantity, String totalAmount, String status) {
        this.orderNo = orderNo;
        this.date = date;
        this.trackingNo = trackingNo;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
