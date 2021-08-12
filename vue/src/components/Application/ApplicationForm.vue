<template>
  <div class="container">

   <div :class="'m-1 alert alert-success alert-dismissible  '  + (isSubmitted ? 'show' :'hide') " role="alert">
     Application submitted Successfully.
     <button @click="isSubmitted=false" class="btn btn-outline-dark border-0 bg-transparent float-end"> x</button>
   </div>
    <h2 class="display-4"> Rental Application</h2>
    <h6> For inquiries about the rental property, please call (888)888-8888</h6>
    <br>
    <form novalidate v-on:submit.prevent="submit">


      <div>

        <div class="d-flex flex-row justify-content-between">
          <div class="form-left-side">
            <div class="form-row">
              <div class="col-md-6 mb-3">
                <label for="validationCustom01">First Name</label>
                <input type="firstName" class="form-control" id="validationCustom01" v-model="tenant.firstName"
                       required>
                <div class="valid-feedback">
                  Looks good!
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="validationCustom02">Last name</label>
                <input type="text" class="form-control" id="validationCustom02" v-model="tenant.lastName" required>
                <div class="valid-feedback">
                  Looks good!
                </div>
              </div>
            </div>
            <div class="form-row">
              <div class="col-md-4 mb-3">
                <label for="validationCustom03">Occupation</label>
                <input type="text" class="form-control" id="validationCustom03" v-model="tenant.occupation"
                       required>
                <div class="invalid-feedback">
                  Please provide a valid city.
                </div>
              </div>
              <div class="col-md-3 mb-3">
                <label for="validationCustom04">State of Residency</label>
                <input type="text" class="form-control" id="validationCustom04" v-model="tenant.state" required>
                <div class="invalid-feedback">
                </div>
              </div>
              <div class="col-md-3 mb-3">
                <label for="residents">Number of Residents</label>
                <input type="number" class="form-control" id="residents" v-model="tenant.numberOfResidents" required>

                <div class="invalid-feedback">
                </div>
              </div>
<!--              <div class="col-md-4 mb-3">-->
<!--                <label>Choose a move in date</label>-->
<!--                <b-form-datepicker id="example-datepicker" class="mb-2"></b-form-datepicker>-->
<!--              </div>-->
            </div>
          </div>
          <PropertyCard :property="this.$store.state.userDesiredProperty" :non-apply="true"></PropertyCard>

          <Map class="map-class" />
        </div>


        <div>
          <div>
            <p class="font-italic">
              I declare that the information I have provided is true and correct, and contain no misrepresentation. If
              misrepresentations are found after a residential lease agreement is entered into between the Landlord and
              Applicant, the Landlord shall have the option to terminate the residential lease agreement and seek other
              remedies.
            </p>
          </div>
          <div class="form-group">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" checked value="" id="invalidCheck" 
                     required>
              <label class="form-check-label" for="invalidCheck">
                Agree to terms and conditions
              </label>
              <div class="invalid-feedback">
                You must agree before submitting.
              </div>
            </div>
          </div>
          <button class="btn btn-info" type="submit" >Submit form</button>
        </div>


      </div>

    </form>



  </div>

</template>

<script>
import Map from "@/components/Navigation/Map";
import PropertyService from "@/services/PropertyService";
import PropertyCard from "@/components/Property/PropertyCard";
// import moment from "moment";

export default {
  name: "application-form",
  components: {PropertyCard, Map},
  data() {
    return {
      errorMsg: "",
      isSubmitted: false,
      value: '',
      // selectedMoveInDate: '',

      tenant: {
        propertyId: this.$store.state.userDesiredProperty.propertyId,
        username: this.$store.state.user.username,
        email: this.$store.state.user.username,
        firstName: '',
        lastName: '',
        occupation: '',
        state: '',
        numberOfResidents: '',
        amountDue: this.$store.state.userDesiredProperty.price
        // moveInDate: moment().format("MMM Do YYYY").selectedMoveInDate,
      }
    }
  },
  methods: {
    submit() {
      // const newPendingTenant = {
      //   firstName: this.tenant.firstName,
      //   lastName: this.tenant.lastName,
      //   occupation: this.tenant.occupation,
      //   state: this.tenant.state,
      //   numberOfResidents: this.tenant.numberOfResidents,
      //   propertyId: this.$store.state.userDesiredProperty.propertyId,
      //   username: this.$store.state.user.username,
      //   email: this.$store.state.user.username,
      //   moveInDate: moment().format("MMM Do YYYY")
      // }
      console.log(this.tenant);
      PropertyService.addApplication(this.tenant)
          .then(res => {
            
        if (res.status === 200 || res.status === 201) {
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
    }

  }
}

</script>


<style>
.form-left-side {
  width: 50%;
}

.map-class{
  margin-left: 1rem;
}
.hide {
  display: none !important;
}

</style>