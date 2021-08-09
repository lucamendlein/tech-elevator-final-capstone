package com.techelevator.dao;

import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCPropertyDAO implements PropertyDAO{
    private JdbcTemplate jdbcTemplate;

    public JDBCPropertyDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Property> propertyList()  {
        String sql = "SELECT property_id, address_line_1, address_line_2, district, square_footage, bedrooms, bathrooms, price, pets, studio, available, image_url " +
                "FROM property " +
                "where available is true";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        List<Property> propertyList = new ArrayList<Property>();
        while (rows.next()){
            Property property = mapRowToProperty(rows);
            propertyList.add(property);
        }

        return propertyList;
    }

    @Override
    public void createProperty(Property property, String username) {
        String sql = "insert into property (property_id, address_line_1, address_line_2, district, " +
                "square_footage, bedrooms, bathrooms, price, pets, studio, available) " +
                "values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning property_id ";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, property.getAddressLine1(), property.getAddressLine2(), property.getDistrict(), property.getSquareFootage(),
                 property.getBedrooms(), property.getBathrooms(), property.getPrice(), property.isAllowsPets(), property.isStudio(), property.isAvailable());
        rows.next();
        property.setPropertyId(rows.getInt("property_id"));

    }


    private Property mapRowToProperty(SqlRowSet row){
        Property property = new Property();
        property.setPropertyId(row.getInt("property_id"));
        property.setAddressLine1(row.getString("address_line_1"));
        property.setAddressLine2(row.getString("address_line_2"));
        property.setBedrooms(row.getInt("bedrooms"));
        property.setBathrooms(row.getDouble("bathrooms"));
        property.setDistrict(row.getString("district"));
        property.setAllowsPets(row.getBoolean("pets"));
        property.setImageUrl(row.getString("image_url"));
        property.setPrice(row.getDouble("price"));
        property.setSquareFootage(row.getInt("square_footage"));
        property.setIsStudio(row.getBoolean("studio"));
        property.setIsAvailable(row.getBoolean("available"));


        return property;
    }

}
