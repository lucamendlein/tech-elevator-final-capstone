package com.techelevator.dao;

import com.techelevator.model.Tenant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class JDBCTenantDAO implements TenantDAO{
    private JdbcTemplate jdbcTemplate;

    public JDBCTenantDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void requestTenant(Tenant tenant, int propertyId) {
        String sql = "Insert Into tenant (tenant_id, amount_due, property_id, user_id , approve_tenant, first_name, last_name, state, number_of_residents, move_in_date, email, occupation)\n" +
                "        values (default, 0, ?, (select user_id from users where username = ?), 'Pending', ?, ?, ?, ?, ?, ?, ?) returning tenant_id;";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, propertyId, tenant.getUsername(), tenant.getFirstName(), tenant.getLastName(), tenant.getState(), tenant.getNumberOfResidents(),
                tenant.getMoveInDate(), tenant.getEmail(), tenant.getOccupation());
        rows.next();
        tenant.setTenantId(rows.getInt("tenant_id"));

    }

    @Override
    public List<Tenant> listPendingTenants() {
        String sql = "select tenant_id, amount_due, property_id, user_id , approve_tenant, first_name, last_name, state, number_of_residents, move_in_date, email, occupation " +
                "from tenant  ";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        List<Tenant> pendingTenants = new ArrayList<Tenant>();
        while(rows.next()){
            Tenant tenant = mapRowToTenant(rows);
            pendingTenants.add(tenant);
        }
        return pendingTenants;
    }

    @Override
    public void approveTenant(Tenant tenant, String approval_status) {
        String sql = "update tenant set approve_tenant = ? where tenant_id = ? ";
        jdbcTemplate.update(sql, approval_status , tenant.getTenantId());


    }



    private Tenant mapRowToTenant(SqlRowSet row){
        Tenant tenant = new Tenant();
        tenant.setTenantId(row.getInt("tenant_id"));
        tenant.setUsername(row.getString("email")); //setting username as email
        tenant.setAmountDue(row.getDouble("amount_due"));
        tenant.setPropertyId(row.getInt("property_id"));
        tenant.setUserId(row.getInt("user_id"));
        tenant.setApprovalStatus(row.getString("approve_tenant"));
        tenant.setFirstName(row.getString("first_name"));
        tenant.setLastName(row.getString("last_name"));
        tenant.setState(row.getString("state"));
        tenant.setNumberOfResidents(row.getInt("number_of_residents"));
        if (row.getDate("move_in_date") != null) {
            tenant.setMoveInDate(row.getDate("move_in_date").toLocalDate());
        }
        tenant.setEmail(row.getString("email"));
        tenant.setOccupation(row.getString("occupation"));
        return tenant;

    }
}
