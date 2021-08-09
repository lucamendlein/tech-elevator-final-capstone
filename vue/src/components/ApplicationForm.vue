<template>
  <div class="container">

    <div :class="'m-1 alert alert-success alert-dismissible  '  + (isSubmitted ? 'show' :'hide') " role="alert">
      Application submitted Successfully.
      <button @click="isSubmitted=false" class="btn btn-outline-dark border-0 bg-transparent float-end"> x</button>
    </div>
    <h2 class="display-4"> Rental Application</h2>
    <h6> For inquires about the rental property, please call (888)888-8888</h6>
    <br>
    <form novalidate v-on:submit.prevent="submit">


      <div>

        <div class="d-flex flex-row">
          <div class="form-left-side">
            <div class="form-row">
              <div class="col-md-6 mb-3">
                <label for="validationCustom01">First Name</label>
                <input type="firstName" class="form-control" id="validationCustom01" v-model="application.firstName"
                       required>
                <div class="valid-feedback">
                  Looks good!
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="validationCustom02">Last name</label>
                <input type="text" class="form-control" id="validationCustom02" v-model="application.lastName" required>
                <div class="valid-feedback">
                  Looks good!
                </div>
              </div>
            </div>
            <div class="form-row">
              <div class="col-md-4 mb-3">
                <label for="validationCustom03">Occupation</label>
                <input type="text" class="form-control" id="validationCustom03" v-model="application.occupation"
                       required>
                <div class="invalid-feedback">
                  Please provide a valid city.
                </div>
              </div>
              <div class="col-md-3 mb-3">
                <label for="validationCustom04">State of Residency</label>
                <input type="text" class="form-control" id="validationCustom04" v-model="application.state" required>
                <div class="invalid-feedback">
                </div>
              </div>
              <div class="col-md-3 mb-3">
                <label for="residents">Number of Residents</label>
                <input type="number" class="form-control" id="residents" v-model="application.residents" required>

                <div class="invalid-feedback">
                </div>
              </div>
              <div class="col-md-4 mb-3">
                <label>Choose a move in date</label>
                <b-form-datepicker id="example-datepicker" v-model="application.moveInDate" class="mb-2"></b-form-datepicker>
              </div>
            </div>
          </div>
          <PropertyCard :property="this.$store.state.userDesiredProperty" :non-apply="true"></PropertyCard>
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
              <input class="form-check-input" type="checkbox" checked value="" id="invalidCheck" v-model="date"
                     required>
              <label class="form-check-label" for="invalidCheck">
                Agree to terms and conditions
              </label>
              <div class="invalid-feedback">
                You must agree before submitting.
              </div>
            </div>
          </div>
          <button class="btn btn-primary" type="submit">Submit form</button>
        </div>

      </div>
      <Map class="float-end"/>

    </form>


  </div>

</template>

<script>
import propertyService from "@/services/PropertyService";
import PropertyCard from "@/components/PropertyCard";
import Map from "@/components/Map";
//import moment from "moment";
export default {
  name: "application-form",
  components: {Map, PropertyCard},
  data() {
    return {
      isSubmitted: false,
      value: '',
      application: {
        prop: '',
        firstName: '',
        lastName: '',
        occupation: '',
        state: '',
        residents: '',
        moveInDate: '',
      }
    }
  },
  methods: {
    submit() {
      const newApplicant = {
        firstName: this.application.firstName,
        lastName: this.application.lastName,
        occupation: this.application.occupation,
        state: this.application.state,
        resident: this.application.residents,
        propertyId:this.$store.state.userDesiredProperty.propertyID,
        username: this.$store.state.user.username,
        email: this.$store.state.user.username,
        moveInDate: this.$store.state.user.date
             //moment().format("MMM Do YYYY")
      }
      propertyService.addApplication(newApplicant)
          .then(res => {
        if (res.status === 200) {
          this.isSubmitted = true;

        }
      })
    }
  },

}

</script>


<style>
.form-left-side {
  width: 50%;
}

.hide {
  display: none !important;
}

</style>