package com.techelevator.dao;

import com.techelevator.model.Tenant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
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
        return null;
    }

    @Override
    public Tenant approveTenant(Tenant tenant, String username) {
        return null;
    }
}
