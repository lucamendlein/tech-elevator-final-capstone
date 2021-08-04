package com.techelevator.model;

public class Property {
   private int propertyID;
    private String addressLine1;
    private String addressLine2;
    private String  district;
    private int squareFootage;
    private int bedrooms;
    private double bathrooms;
    private double price;
    private boolean allowsPets;
    private String imageUrl;
    private boolean isStudio;
    private boolean isAvailable;

    public Property() {
    }

    public Property(int propertyID, String addressLine1, String addressLine2, String district,
                    int squareFootage, int bedrooms, double bathrooms, double price, boolean allowsPets, String imageUrl, boolean isStudio, boolean isAvailable) {
        this.propertyID = propertyID;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.district = district;
        this.squareFootage = squareFootage;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.price = price;
        this.allowsPets = allowsPets;
        this.imageUrl = imageUrl;
        this.isStudio = isStudio;
        this.isAvailable = isAvailable;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(double bathrooms) {
        this.bathrooms = bathrooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAllowsPets() {
        return allowsPets;
    }

    public void setAllowsPets(boolean allowsPets) {
        this.allowsPets = allowsPets;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isStudio() {
        return isStudio;
    }

    public void setStudio(boolean isStudio) {
        this.isStudio = isStudio;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
