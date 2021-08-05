package com.techelevator.model;

public class Tenant {
   private int  tenantId;
   private double amountDue;
   private String workOrder;
   private int propertyId;
   private int userId;

    public Tenant(int tenantId, double amountDue, String workOrder, int propertyId, int userId) {
        this.tenantId = tenantId;
        this.amountDue = amountDue;
        this.workOrder = workOrder;
        this.propertyId = propertyId;
        this.userId = userId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public String getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(String workOrder) {
        this.workOrder = workOrder;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
