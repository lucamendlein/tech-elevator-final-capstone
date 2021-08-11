package com.techelevator.controller;

import com.techelevator.dao.WorkOrderDAO;
import com.techelevator.model.Tenant;
import com.techelevator.model.WorkOrder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

public class WorkOrderController {
    private WorkOrderDAO workOrderDAO;

    public WorkOrderController(WorkOrderDAO workOrderDAO) {
        this.workOrderDAO = workOrderDAO;
    }

    @RequestMapping(path = "/work-orders/{id}", method = RequestMethod.POST)
    public WorkOrder addWorkOrder(@RequestBody WorkOrder workOrder, @PathVariable(name = "id") int userId, Principal principal) {

        workOrderDAO.addWorkOrder(workOrder, userId);
        return workOrder;
    }
}



