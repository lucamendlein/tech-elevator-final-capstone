<template>
  <div>
      <tr v-for="property in filterProperties" v-bind:key="property.id"></tr>
      </div>
</template>

<script>
import PropertyService from '../services/PropertyService.js'
export default {
    name: "property-details",
    methods: {
        getProperty() {
            PropertyService.getProperties().then(response => {
                this.$store.commit('GET_PROPERTY_LIST', response.data)
                
                console.log(response.data);
                });
            }
        },
        
    
    computed: {
        filterProperties() {
            const property = this.$store.state.property;
            const filterProperties = this.$store.state.filterProperties;

           

            return property.filter((property) => {
                return filterProperties ? property.state === filterProperties : true;

                
            });

            
        }
    }
    

}
</script>

<style>

</style>