<template>
  <div v-if="tenant" class="building-card card d-flex align-items-center justify-content-center m-2">
  <div class="card-body">
      <div class="p-2">
          <h6 class="card-title">{{ tenant.lastName }} , {{tenant.firstName}}</h6>
          <div class="card-text"> # of Residents: {{tenant.numberOfResidents}}</div>
          <div class="card-text"> Occupation: {{ tenant.occupation}}</div>
          <div class="card-text"> State: {{tenant.state}}</div>
          <div >
        <!-- <router-link v-if="!nonSelect" v-bind:to="{path:`/manage/${tenant.tenantId}`}" class="float-end"><b-button variant="info"
          @click="setSelectedTenant"

        >Go To Tenant</b-button></router-link> -->

            <p class="m-0"><b>Status: &ensp;</b> {{tenant.approveTenant}}</p>
          <p class="m-0"><b>Service Requests? &ensp;</b> <small v-if="tenant.workOrder">Yes </small>
          <small v-else>No</small></p>
          <p class="m-0"><b>Amount Due: &ensp;</b> ${{tenant.amountDue}} </p>
            <button class="btn btn-outline-primary" @click="updateTenantStatus('Approve')"> Approve</button>
            <button class="btn btn-outline-primary float-end">Deny</button>
          
          

      </div>
      </div>
      </div>
  </div>
</template>

<script>
import PropertyService from "@/services/PropertyService";
export default {

props: ['tenant', 'nonSelect'],

data() {
    return {
      visible: false,
      approved: '',
      denied: ''
    }
},
  methods: {
    setSelectedTenant(){
      this.$store.commit("SET_SELECTED_TENANT", this.tenant);
    },
    updateTenantStatus(approvalStatus){

      this.$store.commit('UPDATE_TENANT_STATUS', this.tenant.approveTenant,  approvalStatus)
    },

    Approved() {
      const approvedTenant= {
        tenantId: this.tenant.tenantId,
        propertyId: this.tenant.propertyId,
        userId: this.tenant.userId,
        firstName: this.tenant.firstName,
        lastName: this.tenant.lastName,
        occupation: this.tenant.occupation,
        state: this.tenant.state,
        numberOfResidents: this.tenant.numberOfResidents,
        moveInDate: this.tenant.moveInDate,
        email: this.tenant.email,
        approveTenant: this.tenant.approveTenant

      }
      PropertyService.updateTenants(approvedTenant).then(res => {
        if(res.status === 200 || res.status === 201 ) {

        }
      })


    }
  },

}
</script>

<style>
.builidng-card {
  height: fit-content;
}
.collapse-con {

  padding: 1rem;

}
.btn:focus {
  outline: none;
}
</style>