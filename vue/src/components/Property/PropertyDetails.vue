<template>
  <div>
      <tr v-for="property in filterPropertiesDistrict" v-bind:key="property.id"></tr>
      </div>
</template>

<script>
import PropertyService from '../../services/PropertyService.js'
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
        filterPropertiesDistrict() {
            const property = this.$store.state.property;
            const filterPropertiesDistrict = this.$store.state.filterPropertiesDistrict;
            const filterPropertiesBedrooms = this.$store.state.filterPropertiesBedrooms;

           

            return property.filter((property) => {

                if (filterPropertiesDistrict && filterPropertiesBedrooms) {
                    return property.state;
                }
                

            });

            
        }
    }
    

}
</script>

<style>

</style>