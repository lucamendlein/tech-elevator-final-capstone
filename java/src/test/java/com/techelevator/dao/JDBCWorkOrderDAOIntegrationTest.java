package com.techelevator.dao;

import com.techelevator.model.WorkOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCWorkOrderDAOIntegrationTest extends DAOIntegrationTest{

    private WorkOrderDAO workOrderDAO;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup(){
        jdbcTemplate = new JdbcTemplate(getDataSource());
        workOrderDAO = new JDBCWorkOrderDAO(getDataSource());
    }

    @Test
    public void should_create_new_work_order(){
        int userId = 5;
        String username = "user";

        WorkOrder workOrder = getWorkOrder("plz", "dowork", userId);

        workOrderDAO.addWorkOrder(workOrder);
        Assert.assertTrue(workOrder.getWorkOrderId() > 0);
        String sql = "select work_order_id from work_order where work_order_id = ?";
        WorkOrder workOrderFromDatabase = new WorkOrder();

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, workOrder.getWorkOrderId());
        if (rows.next()){
            workOrderFromDatabase.setWorkOrderId(rows.getInt("work_order_id"));
        }

        Assert.assertEquals(workOrderFromDatabase.getWorkOrderId(), workOrder.getWorkOrderId());




    }

    private WorkOrder getWorkOrder(String workOrder, String workOrderImg, int userId){
        WorkOrder pleaseDoWork = new WorkOrder();
        pleaseDoWork.setWorkOrder(workOrder);
        pleaseDoWork.setWorkOrderImg(workOrderImg);
        pleaseDoWork.setUserId(userId);

        return pleaseDoWork;
    }
}
