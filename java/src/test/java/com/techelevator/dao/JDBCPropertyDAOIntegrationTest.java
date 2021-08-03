package com.techelevator.dao;

import com.techelevator.model.Property;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

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
}
