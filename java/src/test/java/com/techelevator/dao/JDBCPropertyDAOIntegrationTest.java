package com.techelevator.dao;

import com.techelevator.model.Property;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JDBCPropertyDAOIntegrationTest extends DAOIntegrationTest{

    private PropertyDAO propertyDAO;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup() {
        jdbcTemplate = new JdbcTemplate(getDataSource());
        propertyDAO = new JDBCPropertyDAO(getDataSource());
    }

    @Test
    public void should_return_list_of_properties() {
        List<Property> originalList = propertyDAO.propertyList();
        String sql = "insert into property ( address_line_1, address_line_2, district, " +
                "        square_footage, bedrooms, bathrooms, price, pets, floor, studio, available) " +
                "        values ( '123 test', 'apt 12', 'Founders Island', 1000, 4, 2.0, 1100.00, true, 1, false, true)";
        jdbcTemplate.update(sql);
        List<Property> newList = propertyDAO.propertyList();
        Assert.assertEquals(originalList.size() + 1, newList.size());
    }

    @Test
    public void should_create_new_property() {
        String username = "test";
        Property property = getProperty("test","test", 2,"test", 3, 1000, 1500, true, false, true);

        propertyDAO.createProperty(property,username );

        Assert.assertTrue(property.getPropertyID() > 0);

        String sql = "SELECT property_id, address_line_1, address_line_2, district, square_footage, bedrooms, bathrooms, price, pets, image_url, studio, available " +
                "FROM property " +
                "where property_id = ?";
        Property propertyFromDatabase = new Property();
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, property.getPropertyID());
        if (rows.next()) {
            propertyFromDatabase.setPropertyID(rows.getInt("property_id"));
            propertyFromDatabase.setAddressLine1(rows.getString("address_line_1"));
            propertyFromDatabase.setAddressLine2(rows.getString("address_line_2"));
            propertyFromDatabase.setBedrooms(rows.getInt("bedrooms"));
            propertyFromDatabase.setBathrooms(rows.getDouble("bathrooms"));
            propertyFromDatabase.setDistrict(rows.getString("district"));
            propertyFromDatabase.setAllowsPets(rows.getBoolean("pets"));
            propertyFromDatabase.setImageUrl(rows.getString("image_url"));
            propertyFromDatabase.setPrice(rows.getDouble("price"));
            propertyFromDatabase.setSquareFootage(rows.getInt("square_footage"));
            propertyFromDatabase.setStudio(rows.getBoolean("studio"));
            propertyFromDatabase.setAvailable(rows.getBoolean("available"));
        }
        Assert.assertEquals(propertyFromDatabase.getPropertyID(), property.getPropertyID());

    }

    private Property getProperty(String addressLine1, String addressLine2, double bathrooms, String district,
                int bedrooms, double price, int squareFootage, boolean allowsPets, boolean studio, boolean isAvailable){
        Property property = new Property();
        property.setAddressLine1(addressLine1);
        property.setAddressLine2(addressLine2);
        property.setBedrooms(bedrooms);
        property.setBathrooms(bathrooms);
        property.setDistrict(district);
        property.setAllowsPets(allowsPets);
        property.setPrice(price);
        property.setSquareFootage(squareFootage);
        property.setStudio(studio);
        property.setAvailable(isAvailable);
        return property;
    }
}
