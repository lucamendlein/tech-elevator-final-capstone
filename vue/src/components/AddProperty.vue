<template>
  <div>
    <form v-on:submit.prevent="submitForm">
      <div>
        <label for="address-line-1"></label>
        <input id="address-line-1" type="text">
      </div>
      <div>
        <label for="address-line-2"></label>
        <input id="address-line-2" type="text">
      </div>
      <div>
        <label for="district"></label>
        <input id="district" type="text">
      </div>
      <div>
        <label for="square-footage"></label>
        <input id="square-footage" type="number">
      </div>
      <div><label for="bedrooms"></label>
        <input id="bedrooms" type="number">
      </div>
      <div><label for="bathrooms"></label>
        <input id="bathrooms" type="number">
      </div>
      <div>
        <label for="price"></label>
        <input id="price" type="number">
      </div>
      <div>
        <b-checkbox for="allows-pet"></b-checkbox>
      </div>
        <div>
          <label for="image-url"></label>
          <input id="image-url" type="text">
        </div>
        <div>
          <b-checkbox for="is-studio"></b-checkbox>
        </div>
        <div>
          <b-checkbox for="isAvailable"></b-checkbox>
        </div>

    </form>
  </div>

</template>


<script>
//import PropertyService from "@/services/PropertyService";

export default {
  name: "add-property",
  data(){
    return {
      property: {
        addressLine1: '',
        district: '',
        squareFootage: '',
        bedrooms:'',
        bathrooms: '',
        price: '',
        allowsPets: '',
        imageUrl: '',
        isStudio:'',
        isAvailable:''
      }
    }
  },
  method: {

  }
}
</script>


<style>

</style>