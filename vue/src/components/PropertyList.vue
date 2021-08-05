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
      const filter= this.$store.state.filterProperty;
      return properties.filter(property => {
        return filter ? property.district === filter : true;
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