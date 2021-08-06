package com.techelevator.model;

public class Tenant {
   private int  tenantId;
   private double amountDue;
   private String workOrder;
   private int propertyId;
   private int userId;
   private String approveTenant;

    public Tenant() {
    }

    public Tenant(int tenantId, double amountDue, String workOrder, int propertyId, int userId, String approveTenant) {
        this.tenantId = tenantId;
        this.amountDue = amountDue;
        this.workOrder = workOrder;
        this.propertyId = propertyId;
        this.userId = userId;
        this.approveTenant =approveTenant;
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

    public String getApproveTenant() {
        return approveTenant;
    }

    public void setApproveTenant(String approveTenant) {
        this.approveTenant = approveTenant;
    }
}
