<template>
  <div>
    <h3 class ="address1"> Address of property: {{property.addressLine1}}</h3>
    <h3 class="apptNum"> Apartment #: {{property.addressLine2}}</h3>
    <h3 class="district">Distict: {{property.district}}</h3>
    <h3 class="bedrooms" v-if="property.studio"> Studio </h3>
    <h3 v-else-if="property.bedrooms"> {{property.bedrooms}} Bedrooms</h3>
    <h3 class="bathrooms">{{property.bathrooms}} Bath</h3>
    <h3 class="squarefootage ">{{property.squareFootage}}Sqft</h3>
    <h3 class="pets" v-if="property.allowsPets"> Pet allowed </h3>
<!--   <h3 class="floor">Apartment is on {{property.floor}}</h3>-->
    <h3 class="price">${{property.price}} /mo "utilities are not included"</h3>




  </div>

</template>



<script>
export default {
  props: ['property'],
  methods: {

  }
}

</script>

<style>

</style>