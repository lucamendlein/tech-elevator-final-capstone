import axios from 'axios';



export default {
    getProperties(){
        return axios.get('/properties')
    },
    addProperty(property){
        return axios.post('/manage', property)
    },
    addApplication(tenant) {
        return axios.post(`/rental/${tenant.propertyId}`, tenant)

    },
    getTenants(){
        return axios.get('/manage')
    }
    
}