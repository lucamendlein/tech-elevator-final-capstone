package com.techelevator.dao;

import com.techelevator.model.Property;

import java.util.List;

public interface PropertyDAO {

    List<Property> propertyList();

    void createProperty(Property property, String name);
}
