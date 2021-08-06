package com.techelevator.dao;

import com.techelevator.model.Property;
import com.techelevator.model.Tenant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

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
        String username = "test";
        Tenant tenant = getTenant(0, 3,5, "pending");
        tenantDAO.requestTenant(tenant,username);
        Assert.assertTrue(tenant.getTenantId() > 0);
        String sql = "select tenant_id from tenant where tenant_id = ?;";
        Tenant tenantFromDatabase = new Tenant();
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, tenant.getTenantId());
        if (rows.next()) {
            tenantFromDatabase.setTenantId(rows.getInt("tenant_id"));
        }
        Assert.assertEquals(tenantFromDatabase.getTenantId(), tenant.getTenantId());


    }

    private Tenant getTenant( double amountDue, int propertyId, int userId,
                              String approveTenant){
        Tenant tenant = new Tenant();
        tenant.setAmountDue(amountDue);
        tenant.setPropertyId(propertyId);
        tenant.setUserId(userId);
        tenant.setApproveTenant(approveTenant);
        return tenant;



    }
}
