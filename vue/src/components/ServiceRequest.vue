<template>
  <form v-on:submit.prevent="submit">
      <div class="d-flex flex-row">
      <div class="form-left-side">
          <div class=" col-xs-6 mb-3">
    <label for="service-request" class="h4">Service Request:</label>
    <input class="form-control input-lg"  id="service-request"  type="text">
    </div>
    </div>
  </div>
  <button class="btn btn-primary" @submit="updateWorkOrder('do work')" type="submit">Submit</button>
      </form>
</template>

<script>
import PropertyService from "../services/PropertyService"

export default {
    name: "service-request",
    props: ["tenant"],
    data() {
        return {
            isSubmitted: false,
            
        }
    },
    methods: {
        submit() {
            PropertyService.updateWorkOrder(this.tenant)
            .then(response => {
                if (response.status === 200 || response.status === 201) {
                    this.isSubmitted = true;
                }
            })
            .catch(error => {
                this.handleErrorResponse(error, "adding");
            });
        },

        handleErrorResponse(error, verb) {
            if (error.response) {
        this.errorMsg =
          "Error " + verb + " property. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) {
        this.errorMsg =
          "Error " + verb + " property. Server could not be reached.";
      } else {
        this.errorMsg =
          "Error " + verb + " property. Request could not be created.";
      }
    
        },
        updateWorkOrder(workOrder){
       PropertyService.updateWorkOrder(this.tenant, workOrder).then(response =>{
           console.log(this.tenant)
           console.log(this.workOrder)
           console.log(response.data)
            this.$store.dispatch("getTenantList", workOrder)
       })

      

    }
    }

    
    
}

</script>

<style>

</style>