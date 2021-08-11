package com.techelevator.dao;

import com.techelevator.model.WorkOrder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
public class JDBCWorkOrderDAO implements WorkOrderDAO {
    private JdbcTemplate jdbcTemplate;

    public JDBCWorkOrderDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addWorkOrder(WorkOrder workOrder) {
        { String sql = "Insert Into work_order (work_order_id, work_order, work_order_img, user_id)" +
                "values (default, ?, ?, ?) returning work_order_id";
            SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, workOrder.getWorkOrder(), workOrder.getWorkOrderImg(), workOrder.getUserId());

            rows.next();
            workOrder.setWorkOrderId(rows.getInt("work_order_id"));

        }
    }
}
