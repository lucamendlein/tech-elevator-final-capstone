<template>
<div class = "container">
  <div :class="'m-1 alert alert-success alert-dismissible  '  + (isSubmitted ? 'show' :'hide') " role="alert">
      Service Request Submitted Successfully.
      </div>
      <p>

          
      </p>
  <p-6 class="lead"> Here at Gotham City Real Estate, we take our service requests very seriously. Please give a detailed description of what needs repaired or replaced.
    We will definitely get to it in timely manner!
  GCR management</p-6>
  <form v-on:submit.prevent="submit" >
    <div class="d-flex flex-row">
      <div class="form-left-side">
        <div class="col-xs-6 mb-3 py-5">
          <label for="workOrder" class="h4">Service Request:</label>
          <textarea
            class="form-control input-lg" v-model="workOrder.workOrder"
            
            id="workOrder"
            type="text"
          />
          
<!--          <label for="workOrderImg" class="h4">Upload Photo:</label>-->
<!--          <input-->
<!--              class="form-control input-lg" v-model="workOrder.workOrderImg"-->

<!--              id="workOrderImg"-->
<!--              type="text"-->
<!--          />-->
          
        </div>
      </div>
    </div>
    <div>

    <button type="submit" class="btn btn-info">
      Submit
    </button>
    </div>
  </form>
  </div>
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