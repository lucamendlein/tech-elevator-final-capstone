<template>
  <div>
     
      </div>
</template>

<script>
import PropertyService from '../../services/PropertyService.js'
export default {
    name: "tenant-details",
    methods: {
        getTenants() {
            PropertyService.getTenants().then(response => {
                this.$store.commit('GET_TENANT_LIST', response.data)

                console.log(response.data);
                });
            }
        },
    

}
</script>

<style>

</style>