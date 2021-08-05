<template>

  <!--    <h3 class ="address1"> Address of property: {{property.addressLine1}}</h3>-->
  <!--    <h3 class="apptNum"> Apartment #: {{property.addressLine2}}</h3>-->
  <!--    <h3 class="district">Distict: {{property.district}}</h3>-->
  <!--    <h3 class="bedrooms" v-if="property.studio"> Studio </h3>-->
  <!--    <h3 v-else-if="property.bedrooms"> {{property.bedrooms}} Bedrooms</h3>-->
  <!--    <h3 class="bathrooms">{{property.bathrooms}} Bath</h3>-->
  <!--    <h3 class="squarefootage ">{{property.squareFootage}}Sqft</h3>-->
  <!--    <h3 class="pets" v-if="property.allowsPets"> Pet allowed </h3>-->
  <!--&lt;!&ndash;   <h3 class="floor">Apt on {{property.floor}}</h3>&ndash;&gt;-->
  <!--    <h3 class="price">${{property.price}} /mo "utilities are not included"</h3>-->

  <div class="card d-flex align-items-center justify-content-center m-2">

    <img class="card-img-top" :src="property.imageURL">
    <div class="card-body">
      <h6 class="card-title">{{ property.addressLine1 }}</h6>
      <div class="card-text">{{ property.addressLine1 }}</div>
      <div class="card-text">${{ property.price }} /mo "utilities are not included"</div>
      <div class="card-text">{{property.bathrooms}} Bath</div>
      <b-dropdown text="More" variant="outline-info" class="m-1">
        <b-dropdown-item>{{property.squareFootage}}Sqft</b-dropdown-item>
        <b-dropdown-item v-if="property.allowsPets">Pet allowed</b-dropdown-item>
        <b-dropdown-item >{{property.floor}}</b-dropdown-item>
        <b-dropdown-item v-if="property.studio">Studio</b-dropdown-item>
      </b-dropdown>
    </div>
  </div>


</template>


<script>
export default {

  props: ['property'],
  methods: {}
}

</script>

<style>

.card-img-top {
  width: 20rem;
  height: 13rem;
}

</style>