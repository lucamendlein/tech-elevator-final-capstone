<template>
  <div>
    <div v-for="property in $store.state.properties" v-bind:key="property.id" :property="property">
      <div>
        {{ property.district }}
      </div>
    </div>
  </div>
</template>

<script>
import PropertyService from "@/services/PropertyService"

export default {
  name: "property-list",
  components: {
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
  created() {
    this.getProperty();
  },


  computed: {
    filterProperties() {
      const properties = this.$store.state.properties;
      const filterProperties = this.$store.state.filterProperties;


      return properties.filter((property) => {
        return filterProperties ? property.state === filterProperties : true;


      });
    }


  }


}
</script>

<style>

</style>