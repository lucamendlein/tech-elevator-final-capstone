import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    properties: [],
    tenants: [],
    property: {
      addressLine1: '',
        addressLine2: '',
        district: '',
        squareFootage: '',
        bedrooms:'',
        bathrooms: '',
        price: '',
        allowsPets: '',
        imageUrl: '',
        isStudio:'',
        isAvailable:''
    },
    tenant: {
      tenantId: '',
      propertyId: '',
        userId: '',
        firstName: '',
        lastName: '',
        occupation: '',
        state: '',
        numberOfResidents: '',
        moveInDate: '',
        email: '',
      approveTenant: ''


    },
    selectedTenant: undefined,
    userDesiredProperty: undefined,
    filterPropertyDistrict: '',
    filterPropertyBedrooms: '',
    filterPropertyBathrooms: '',
    filterPropertyPrice: '',
    filterPropertyPets: ''
  },
  mutations: {
    SET_USER_DESIRED_PROPERTY(state,userDesiredProperty){
      state.userDesiredProperty=userDesiredProperty;
    },
    SET_SELECTED_TENANT(state, selectedTenant){
      state.selectedTenant=selectedTenant;
    },
    APPROVE_TENANT_STATUS(state, tenant, approveTenant) {

      state.approveTenant = approveTenant;
    },

    
    UPDATE_DISTRICT_FILTER(state, filterPropertyDistrict) {
      state.filterPropertyDistrict = filterPropertyDistrict
    },
    UPDATE_BEDROOM_FILTER(state, filterPropertyBedrooms){
      state.filterPropertyBedrooms = filterPropertyBedrooms
    },
    UPDATE_BATHROOM_FILTER(state, filterPropertyBathrooms){
      state.filterPropertyBathrooms = filterPropertyBathrooms
    },
    UPDATE_PET_FILTER(state, filterPropertyPets){
      state.filterPropertyPets = filterPropertyPets
    },
    UPDATE_PRICE_FILTER(state, filterPropertyPrice) {
      state.filterPropertyPrice = filterPropertyPrice

    },
    GET_PROPERTY_LIST(state, properties){
      state.properties = properties;
    },
    GET_TENANT_LIST(state, tenants) {
      state.tenants = tenants;
    }
    ,
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
