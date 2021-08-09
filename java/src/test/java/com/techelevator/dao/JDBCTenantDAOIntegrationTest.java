package com.techelevator.dao;

import com.techelevator.model.Property;
import com.techelevator.model.Tenant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.LocalDate;
import java.util.List;

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

    @Test
    public void should_give_list_of_pending_tenants(){
        List<Tenant> tenantList = tenantDAO.listPendingTenants();

        String sql = "Insert Into tenant (tenant_id, amount_due, property_id, user_id , approve_tenant, first_name, last_name, state, number_of_residents, move_in_date, email, occupation)\n" +
                "        values (default, 0,  3, 5, 'Pending', 'test', 'test', 'oh', 1, '2021-12-13', 'test', 'test' )";
        jdbcTemplate.update(sql);
        List<Tenant> newList = tenantDAO.listPendingTenants();
        Assert.assertEquals(tenantList.size() + 1, newList.size());

    }

    @Test
    public void should_update_approve_tenant(){
        Tenant tenant = getTenant(0, 3,1, "Pending",
                "test", "test", "NJ", 1, LocalDate.now(), "test", "test"  );
        String approve = "Approve";
        tenant.setTenantId(12);
        tenantDAO.approveTenant(tenant, approve);


        Assert.assertEquals("Approve", tenant.getApproveTenant());


    }


    private Tenant getTenant(double amountDue, int propertyId, int userId,
                             String approveTenant, String firstName, String lastName, String state, int numberOfResidents,
                             LocalDate moveInDate, String email, String occupation){
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
