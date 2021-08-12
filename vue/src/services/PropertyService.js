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
     },
    // getGeoLocation(address){
    //     return axios.get(`https://maps.googleapis.com/maps/api/geocode/json?address=${address.replace(/\s+/g, '+')}&key=AIzaSyDaANXtb--5mO-NGs8f9sIrfds2Du8Yhc4`)
    //             .then(res=>res.data['results'][0]['geometry'])
    //
    //
    // }

}