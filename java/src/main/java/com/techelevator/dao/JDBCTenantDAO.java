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
    public void requestTenant(Tenant tenant, String username) {
        String sql = "Insert Into tenant (tenant_id, amount_due, property_id, user_id , approve_tenant)\n" +
                "        values (default, 0, ?, ?, 'Pending') returning tenant_id";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, tenant.getPropertyId(), tenant.getUserId() );
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
