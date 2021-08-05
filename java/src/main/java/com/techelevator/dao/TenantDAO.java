package com.techelevator.dao;

import com.techelevator.model.Tenant;

public interface TenantDAO {

    void createTenant(Tenant tenant, String username);
}
