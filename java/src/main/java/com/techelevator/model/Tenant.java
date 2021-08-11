package com.techelevator.model;

import java.time.LocalDate;

public class Tenant {
    private int tenantId;
    private double amountDue;

    private int propertyId;
    private int userId;
    private String approvalStatus;
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

    public Tenant(int tenantId, double amountDue,  int propertyId, int userId, String approvalStatus,
                  String firstName, String lastName, String state,
                  int numberOfResidents, LocalDate moveInDate, String email, String occupation,String username) {
        this.tenantId = tenantId;
        this.amountDue = amountDue;
        this.propertyId = propertyId;
        this.userId = userId;
        this.approvalStatus = approvalStatus;
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

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
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
