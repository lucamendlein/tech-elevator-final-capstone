package com.techelevator.model;

public class WorkOrder {
    private int workOrderId;
    private String workOrder;
    private String workOrderImg;
    private int userId;

    public WorkOrder() {

    }

    public WorkOrder(int workOrderId, String workOrder, String workOrderImg, int userId) {
        this.workOrderId = workOrderId;
        this.workOrder = workOrder;
        this.workOrderImg = workOrderImg;
        this.userId = userId;

    }

    public int getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(int workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(String workOrder) {
        this.workOrder = workOrder;
    }

    public String getWorkOrderImg() {
        return workOrderImg;
    }

    public void setWorkOrderImg(String workOrderImg) {
        this.workOrderImg = workOrderImg;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}

