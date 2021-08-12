<template>
  <div class="tenant-list-con container m-5 p-5 d-flex flex-row flex-wrap bg-white">
<!--    <tenant-card v-for="tenant in this.$store.state.tenants" v-bind:key="tenant.tenantId" :tenant="tenant">-->
<!--    </tenant-card>-->
    <b-table striped hover :items="tenantsList">
      <template #cell(approvalStatus)="data">
        <span
          :class=" {
            badge:true,
            'text-danger': data.value === 'Deny',
            'text-success': data.value === 'Approve',
            'text-secondary': data.value === 'Pending',

          } "
        >{{data.value}}</span>

      </template>

      <template #cell(action)="data">
        <div class="d-flex flex-row">

          <button @click="updateTenant(data.item,'Approve')" v-if="data.value==='Deny' || data.value==='Pending'" class="btn btn-success mx-1">

            <b-icon icon="check"></b-icon>

          </button>
          <button @click="updateTenant(data.item,'Deny')" v-if="data.value==='Approve' || data.value==='Pending' " class="btn btn-danger mx-1" >
            <b-icon icon="x"></b-icon>
          </button>

        </div>


      </template>

    </b-table>
  </div>
</template>

<script>

import PropertyService from "@/services/PropertyService"


export default {
  name: "tenant-list",
  components: {
  },
  computed:{
    tenantsList: function () {
        return this.$store.state.tenants.map(tenant=> {
          return ({
            ...tenant, Action : tenant.approvalStatus
          })
        });
    }
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
    },

    updateTenant(tenant,status) {

      PropertyService.updateTenants(tenant,status).then(res => {
        console.log(res.data);
        this.$store.dispatch("getTenantList");
      })


    }
  },
  
  created() {
    this.getTenants();
  },
}


</script>

<style>
.tenant-list-con{
  width: fit-content !important;
}
</style>