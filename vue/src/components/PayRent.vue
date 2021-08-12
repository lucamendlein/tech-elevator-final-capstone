<template>

<div class = "container">
    <div :class="'m-1 alert alert-success alert-dismissible  '  + (isSubmitted ? 'show' :'hide') " role="alert">
      Rent Paid Successfully.
      </div>
    <p></p>
    <p class = "lead"> Rent is due every month on the 1st of the month.  If you have provided the property manager with your credit card information, you 
        can pay your rent through this portal.</p>
  
  <form v-on:submit.prevent="submit" >
    
    <div>

    <button type="submit" class="btn btn-info">
      Pay Rent
    </button>
    </div>
  </form>
  </div>
</template>

<script>
import PropertyService from "../services/PropertyService";

export default {
    name: "pay-rent",
    data() {
        return {
            errorMsg: "",
            isSubmitted: false,
            tenant: {
                username: this.$store.state.user.username,
                email: this.$store.state.user.username,
                userId: this.$store.state.user.id,
                amountDue: 0
            }
        }
    },
    methods: {
        submit() {
            PropertyService.payRent(this.tenant)
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
                "Error" + verb + " rent. Server could not be reached.";
            } else {
                this.errorMsg = 
                "Error" + verb + " rent. Request could not be created."
            }
        },
        getCurrentId(userId){
        this.$store.commit("SET_USER_ID", userId)
    }
    }

}
</script>

<style>

</style>