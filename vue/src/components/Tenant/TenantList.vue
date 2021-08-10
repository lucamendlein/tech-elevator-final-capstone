<template>
  <div class="container d-flex flex-row flex-wrap">
    <tenant-card v-for="tenant in this.$store.state.tenants" v-bind:key="tenant.tenantId" :tenant="tenant">
    </tenant-card>
  </div>
</template>

<script>

import PropertyService from "@/services/PropertyService"
import TenantCard from "@/components/Tenant/TenantCard";


export default {
  name: "tenant-list",
  components: {
    TenantCard
  },
  methods: {
    getTenants() {
      PropertyService.getTenants().then(response => {
        console.log(response.data);
        this.$store.commit('GET_TENANT_LIST', response.data)
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
    this.getTenants();
  },
}


</script>

<style>
</style>