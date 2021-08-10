<template>
  <div class="container w-100 h-100 d-flex flex-row flex-wrap">
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
import PropertyCard from "@/components/Property/PropertyCard";


export default {
  name: "property-list",
  components: {
    PropertyCard
  },
  methods: {
    getProperty() {
      PropertyService.getProperties().then(response => {
        console.log(response.data);
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
      const filteredParams = {
        "district": this.$store.state.filterPropertyDistrict,
        "bedrooms": this.$store.state.filterPropertyBedrooms,
        "bathrooms": this.$store.state.filterPropertyBathrooms,
        "allowsPets": this.$store.state.filterPropertyPets,
        "price": this.$store.state.filterPropertyPrice

      }
      let filteredProperties = this.$store.state.properties;
      Object.keys(filteredParams).forEach(property => {
        filteredProperties = filterByJSONProperty(property, filteredParams[property], filteredProperties)
      });

      console.log('filtered list',filteredProperties);
      return filteredProperties;
    }
  },
  created() {
    this.getProperty();
  },
}

function filterByJSONProperty(prop, desiredValue, collection) {

  return collection.filter(obj => {
    return ( prop === "price"
        ? (!desiredValue || (parseInt(obj[prop]) <= parseInt(desiredValue))) //for price
        : (!desiredValue || obj[prop] === desiredValue) //for other props
    )
  })
}

</script>

<style>
</style>