package com.techelevator.controller;

import com.techelevator.dao.TenantDAO;
import com.techelevator.model.Tenant;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class TenantController {
    private TenantDAO tenantDAO;


    public TenantController (TenantDAO tenantDAO){
        this.tenantDAO = tenantDAO;
    }

    //using the tenant object to marshall the add
    @RequestMapping(path = "/properties/{id}", method = RequestMethod.POST)
    public Tenant createTenant(@RequestBody Tenant tenant, @PathVariable(name = "id") int propertyId){

        tenantDAO.requestTenant(tenant, propertyId);
        return tenant;
    }

    @RequestMapping(path = "/tenants", method = RequestMethod.GET)
    @ResponseBody
    public List<Tenant> getPendingTenants() {
        return tenantDAO.listPendingTenants();
    }

    @RequestMapping(path = "/tenants/{updateStatus}", method = RequestMethod.PUT)
    public void updateTenant(@RequestBody Tenant tenant,  @PathVariable(name="updateStatus") String approvalStatus) {
        tenantDAO.approveTenant(tenant, approvalStatus);
    }

    @RequestMapping(path = "/tenants/rent/{id}", method = RequestMethod.PATCH)
    public void payTenantRent(@RequestBody Tenant tenant, @PathVariable(name="id") int userId) {
        tenantDAO.payTenantRent(tenant, userId);
    }


}
