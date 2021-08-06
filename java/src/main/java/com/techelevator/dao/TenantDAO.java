package com.techelevator.dao;

import com.techelevator.model.Tenant;

import java.util.List;

public interface TenantDAO {

    void requestTenant(Tenant tenant, String username);

    List<Tenant> listPendingTenants();

    Tenant approveTenant(Tenant tenant, String username);
}
