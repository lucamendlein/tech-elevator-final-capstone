package com.techelevator.dao;

import com.techelevator.model.Tenant;

import java.util.List;

public interface TenantDAO {

    void requestTenant(Tenant tenant, int propertyId);

    List<Tenant> listPendingTenants();

    void approveTenant(int tenantId, String approve);
}
