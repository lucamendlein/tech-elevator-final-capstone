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
<<<<<<< HEAD
<<<<<<< HEAD
                "values (default, ?, ?, (select user_id from users where user_id = ?)) returning work_order_id;";
            SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, workOrder, workOrder.getWorkOrderImg(), workOrder.getUserId()) ;
=======
                "values (default, ?, ?, (select user_id from users where username = ?)) returning work_order_id";
            SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, workOrder.getWorkOrder(), workOrder.getWorkOrderImg(), name);
>>>>>>> 34721866bf1195ad4d1b292d05e3481924755463
=======
                "values (default, ?, ?, ?) returning work_order_id";
            SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, workOrder.getWorkOrder(), workOrder.getWorkOrderImg(), workOrder.getUserId());
>>>>>>> 258c1a833760c73c5eb0b36beb357878bec4e7ee
            rows.next();
            workOrder.setWorkOrderId(rows.getInt("work_order_id"));

        }
    }
}
