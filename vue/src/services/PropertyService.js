import axios from 'axios';



export default {
    getProperties(){
        return axios.get('/properties')
    },
    addProperty(property){
        return axios.post('/properties', property)
    },
    addApplication(tenant) {
        return axios.post(`/properties/${tenant.propertyId}`, tenant)

    },
    getTenants(){
        return axios.get('/tenants')
    },
    updateTenants(tenant){
        return axios.put(`/tenants/${tenant.tenantId}`, tenant)
    },
    addServiceRequest(tenant){
        return axios.put(`/tenants/${tenant.tenantId}/tenant-home`, tenant)
    }

}