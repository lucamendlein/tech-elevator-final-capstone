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
        String sql = "SELECT property_id, address_line_1, address_line_2, district, square_footage, bedrooms, bathrooms, price, pets, floor, studio, available " +
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




    private Property mapRowToProperty(SqlRowSet row){
        Property property = new Property();
        property.setPropertyID(row.getInt("property_id"));
        property.setAddressLine1(row.getString("address_line_1"));
        property.setAddressLine2(row.getString("address_line_2"));
        property.setBedrooms(row.getInt("bedrooms"));
        property.setBathrooms(row.getDouble("bathrooms"));
        property.setDistrict(row.getString("district"));
        property.setAllowsPets(row.getBoolean("pets"));
        property.setFloor(row.getInt("floor"));
        property.setPrice(row.getDouble("price"));
        property.setSquareFootage(row.getInt("square_footage"));
        property.setStudio(row.getBoolean("studio"));
        property.setAvailable(row.getBoolean("available"));


        return property;
    }

}
