<template>

  <form v-on:submit.prevent="submit" >
    <div :class="'m-1 alert alert-success alert-dismissible  '  + (isSubmitted ? 'show' :'hide') " role="alert">
      Application submitted Successfully.
      <button @click="isSubmitted=false" class="btn btn-outline-dark border-0 bg-transparent float-end"> x</button>
    </div>

    <div class="d-flex flex-row">
      <div class="form-left-side">
        <div class="col-xs-6 mb-3">
          <label for="workOrder" class="h4">Service Request:</label>
          <input
            class="form-control input-lg" v-model="workOrder.workOrder"
            
            id="workOrder"
            type="text"
          />
          
          <label for="workOrderImg" class="h4">Upload Photo:</label>
          <input
              class="form-control input-lg" v-model="workOrder.workOrderImg"

              id="workOrderImg"
              type="text"
          />
          
        </div>
      </div>
    </div>
    <div>

    <button type="submit" class="btn btn-primary">
      Submit
    </button>
    </div>
  </form>

</template>

<script>
import PropertyService from "../services/PropertyService";

export default {
  name: "service-request",
  
  data() {
    return {
      isSubmitted: false,
      workOrder: {
          workOrder: '',
          workOrderImg: '',
         userId: this.$store.state.user.id
      },
    };
  },
  methods: {
    submit() {
      PropertyService.addWorkOrder(this.workOrder)
        .then((response) => {
          if (response.status === 200 || response.status === 201) {
            this.isSubmitted = true;
          }
        })
        .catch((error) => {
          this.handleErrorResponse(error, "adding");
        });
    },

    handleErrorResponse(error, verb) {
      if (error.response) {
        this.errorMsg =
          "Error " +
          verb +
          " property. Response received was '" +
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

    getCurrentId(userId){
        this.$store.commit("SET_USER_ID", userId)
    }
  },
};
</script>

<style>
</style>