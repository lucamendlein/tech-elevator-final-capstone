package com.techelevator.model;

import java.time.LocalDate;

public class Tenant {
    private int tenantId;
    private double amountDue;
    private String workOrder;
    private int propertyId;
    private int userId;
    private String approve_tenant;
    private String firstName;
    private String lastName;
    private String state;
    private int numberOfResidents;
    private LocalDate moveInDate;
    private String email;
    private String occupation;
    private String username;

    public Tenant() {
    }

    public Tenant(int tenantId, double amountDue, String workOrder, int propertyId, int userId, String approve_tenant,
                  String firstName, String lastName, String state,
                  int numberOfResidents, LocalDate moveInDate, String email, String occupation,String username) {
        this.tenantId = tenantId;
        this.amountDue = amountDue;
        this.workOrder = workOrder;
        this.propertyId = propertyId;
        this.userId = userId;
        this.approve_tenant = approve_tenant;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.numberOfResidents = numberOfResidents;
        this.moveInDate = moveInDate;
        this.email = email;
        this.username = username;
        this.occupation = occupation;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
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

    public String getApprove_tenant() {
        return approve_tenant;
    }

    public void setApprove_tenant(String approve_tenant) {
        this.approve_tenant = approve_tenant;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getNumberOfResidents() {
        return numberOfResidents;
    }

    public void setNumberOfResidents(int numberOfResidents) {
        this.numberOfResidents = numberOfResidents;
    }

    public LocalDate getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(LocalDate moveInDate) {
        this.moveInDate = moveInDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
