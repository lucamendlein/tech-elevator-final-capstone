package com.techelevator.controller;

import com.techelevator.dao.TenantDAO;
import com.techelevator.model.Tenant;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
public class TenantController {
    private TenantDAO tenantDAO;


    public TenantController (TenantDAO tenantDAO){
        this.tenantDAO = tenantDAO;
    }

    //using the tenant object to marshall the add
    @RequestMapping(path = "/rental/{id}", method = RequestMethod.POST)
    public Tenant createTenant(@RequestBody Tenant tenant, @PathVariable(name = "id") int propertyId, Principal principal){

        tenantDAO.requestTenant(tenant, propertyId);
        return tenant;
    }

}
