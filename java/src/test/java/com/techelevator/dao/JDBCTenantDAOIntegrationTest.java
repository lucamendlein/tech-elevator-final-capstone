package com.techelevator.dao;

import com.techelevator.model.Property;
import com.techelevator.model.Tenant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.LocalDate;

public class JDBCTenantDAOIntegrationTest extends DAOIntegrationTest{
    private TenantDAO tenantDAO;
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup() {
        jdbcTemplate = new  JdbcTemplate(getDataSource());
        tenantDAO = new JDBCTenantDAO(getDataSource());
    }

    @Test
    public void should_create_tenant(){
        int propertyId = 3;
        String username = "user";

        Tenant tenant = getTenant(0, propertyId,5, "pending",
                "test", "test", "NJ", 1, LocalDate.now(), username, "test"  );
        tenantDAO.requestTenant(tenant, propertyId);
        Assert.assertTrue(tenant.getTenantId() > 0);
        String sql = "select tenant_id from tenant where tenant_id = ?;";
        Tenant tenantFromDatabase = new Tenant();
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, tenant.getTenantId());
        if (rows.next()) {
            tenantFromDatabase.setTenantId(rows.getInt("tenant_id"));
        }
        Assert.assertEquals(tenantFromDatabase.getTenantId(), tenant.getTenantId());


    }

    private Tenant getTenant(double amountDue, int propertyId, int userId,
                             String approveTenant, String firstName, String lastName, String state, int numberOfResidents,
                             LocalDate moveInDate, String email, String occupation ){
        Tenant tenant = new Tenant();
        tenant.setUsername(email); //setting username as email
        tenant.setAmountDue(amountDue);
        tenant.setPropertyId(propertyId);
        tenant.setUserId(userId);
        tenant.setApproveTenant(approveTenant);
        tenant.setFirstName(firstName);
        tenant.setLastName(lastName);
        tenant.setState(state);
        tenant.setNumberOfResidents(numberOfResidents);
        tenant.setMoveInDate(moveInDate);
        tenant.setEmail(email);
        tenant.setOccupation(occupation);
        return tenant;



    }
}
