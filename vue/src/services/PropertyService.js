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
    updateTenants(tenant,status){
        return axios.put(`/tenants/${status}`, tenant)
    },
     addWorkOrder(workOrder){
         return axios.post('/work-orders', workOrder)
     },
     payRent(tenant){
         return axios.patch(`/tenants/rent/${tenant.userId}`, tenant)
     }

}