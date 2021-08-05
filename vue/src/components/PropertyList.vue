<template>
  <div>
    <property-card v-for="property in filteredProperties" v-bind:key="property.id" :property="property">
    </property-card>
    <form>
      <label></label>
      <label></label>
    </form>
  </div>
</template>

<script>

import PropertyService from "@/services/PropertyService"
import PropertyCard from "@/components/PropertyCard";
export default {
  name: "property-list",
  components: {
    PropertyCard
  },
  methods: {
    getProperty() {
      PropertyService.getProperties().then(response => {
        this.$store.commit('GET_PROPERTY_LIST', response.data)
      })
          .catch(error => {
            if (error.response) {
              console.error(error.response.status + ' ' + error.response.statusText)
            } else if (error.request) {
              console.error(error.request)
            } else {
              console.error("unexpected axios error")
            }
          })
    }
  },
  computed: {
    filteredProperties() { 
      const properties= this.$store.state.properties;
      const filterDistrict= this.$store.state.filterPropertyDistrict;
      const filterBedrooms = this.$store.state.filterPropertyBedrooms;
      const filterBathrooms = this.$store.state.filterPropertyBathrooms;
      const filterPets = this.$store.state.filterPropertyPets;
      

      return properties.filter(property => {
        if ((filterDistrict == property.district) && (filterBedrooms == property.bedrooms) && (filterBathrooms == property.bathrooms) && (filterPets == property.allowsPets)) {
            return property;
        } else if ((filterDistrict == '') && (filterBedrooms == '') && (filterBathrooms == '') && (filterPets == '')) {
          return property;
        } else if ((filterDistrict == '') && (filterBedrooms == property.bedrooms) && (filterBathrooms == '') && (filterPets == '')) {
          return property;
        } else if ((filterDistrict == property.district) && (filterBedrooms == '') && (filterBathrooms == '') && (filterPets == '')) {
          return property;
        } else if ((filterDistrict == '') && (filterBedrooms == '') && (filterBathrooms == '') && (filterPets == property.allowsPets)) {
          return property;
        }else if ((filterDistrict == property.district) && (filterBedrooms == property.bedrooms) && (filterBathrooms == '') && (filterPets == '')) {
          return property;
        } else if ((filterDistrict == property.district) && (filterBedrooms == property.bedrooms) && (filterBathrooms == property.bathrooms) && (filterPets == '')) {
          return property;
        } else if ((filterDistrict == '') && (filterBedrooms == property.bedrooms) && (filterBathrooms == property.bathrooms) && (filterPets == property.allowsPets)) {
          return property;
        } else if ((filterDistrict == '') && (filterBedrooms == property.bedrooms) && (filterBathrooms == property.bathrooms) && (filterPets == '')) {
          return property;
        } else if ((filterDistrict == property.district) && (filterBedrooms == '') && (filterBathrooms == property.bathrooms) && (filterPets == '')) {
          return property;
        } 
        
                

            })
    }
  },
  created() {
    this.getProperty();
  },
  }
</script>

<style>
</style>