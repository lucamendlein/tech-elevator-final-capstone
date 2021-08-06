import axios from 'axios';



export default {
    getProperties(){
        return axios.get('/properties')
    },
    addProperty(property){
        return axios.post('/manage', property)
    }
    
}