package com.techelevator.controller;

import com.techelevator.dao.WorkOrderDAO;
import com.techelevator.model.Tenant;
import com.techelevator.model.WorkOrder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@CrossOrigin
@RestController

public class WorkOrderController {
    private WorkOrderDAO workOrderDAO;

    public WorkOrderController(WorkOrderDAO workOrderDAO) {
        this.workOrderDAO = workOrderDAO;
    }

    @RequestMapping(path = "/work-orders", method = RequestMethod.POST)
    public WorkOrder addWorkOrder(@RequestBody WorkOrder workOrder) {

        workOrderDAO.addWorkOrder(workOrder);
        return workOrder;
    }
}



