<template>
  <div class="container">
    <br>
    <h2 class="display-4"> Rental Application</h2>
    <h6> For inquires about the rental property, please call (888)888-8888</h6>
    <br>
    <form class="needs-validation " novalidate>
      <div class="form-row col-md-4 mb-3">
        <div>
          <label for="property">Name of desired property</label>
          <input type="prop" class="form-control" id="property" v-model="prop" required>
          <div class="valid-feedback">
            Looks good!
          </div>
        </div>
      </div>
      <br>
      <br>
      <div class="form-row">
        <div class="col-md-4 mb-3">
          <label for="validationCustom01">First Name</label>
          <input type="firstName" class="form-control" id="validationCustom01" v-model="firstName" required>
          <div class="valid-feedback">
            Looks good!
          </div>
        </div>
        <div class="col-md-4 mb-3">
          <label for="validationCustom02">Last name</label>
          <input type="text" class="form-control" id="validationCustom02" v-model="lastName" required>
          <div class="valid-feedback">
            Looks good!
          </div>
        </div>
      </div>
      <div class="form-row">
        <div class="col-md-3 mb-3">
          <label for="validationCustom03">Occupation</label>
          <input type="text" class="form-control" id="validationCustom03" v-model="occupation" required>
          <div class="invalid-feedback">
            Please provide a valid city.
          </div>
        </div>
        <div class="col-md-3 mb-3">
          <label for="validationCustom04">State of Residency</label>
          <input type="text" class="form-control" id="validationCustom04" v-model="state" required>
          <div class="invalid-feedback">
          </div>
        </div>
        <div class="col-md-3 mb-3">
          <label for="residents">Number of Residents</label>
          <input type="numer" class="form-control" id="residents" v-model="residents" required>
          <div class="invalid-feedback">
          </div>
        </div>
        <div class="col-md-4 mb-3">
          <label>Choose a move in date</label>
          <b-form-datepicker id="example-datepicker" v-model="value" class="mb-2"></b-form-datepicker>
        </div>
      </div>
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
          <input class="form-check-input" type="checkbox" value="" id="invalidCheck" v-model="date" required>
          <label class="form-check-label" for="invalidCheck">
            Agree to terms and conditions
          </label>
          <div class="invalid-feedback">
            You must agree before submitting.
          </div>
        </div>
      </div>
      <button class="btn btn-primary" type="submit">Submit form</button>
    </form>


  </div>

</template>

<script>
export default {
  data() {
    return {
      value: '',
      prop: '',
      firstName: '',
      lastName: '',
      occupation: '',
      state: '',
      residents: '',
      date: '',
    }
  }

}

</script>


<style>

</style>