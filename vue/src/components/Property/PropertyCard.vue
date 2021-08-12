<template>

  <div v-if="property" class="builidng-card card d-flex align-items-left justify-content-center m-2">

    <img class="card-img-top" :src="property.imageUrl">
    <div class="card-body">
      <div class="p-2">
        <h6 class="card-title">{{property.district}}</h6>
        <div class="card-title">{{ property.addressLine1 }}</div>
        <div class="card-text">${{ property.price }} /mo</div>
        <div class="card-text">{{property.bedrooms}} Bedrooms</div>
      </div>
      <div >
        <router-link v-if="!nonApply" v-bind:to="{path:`/properties/${property.propertyId}`}" class="float-end"><b-button variant="info"
          @click="setDesiredProperty"

        >Apply</b-button></router-link>
        <button 
            class="btn btn-outline-info"
            @click="visible = !visible"

        >More
        </button>
        <b-collapse class="collapse-con" :visible="visible">
          <p class="m-0"><b>size: &ensp;</b> {{ property.squareFootage }}Sqft</p>
          <p class="m-0"><b>Bath: &ensp;</b> {{ property.bathrooms }} </p>
          <p class="m-0" v-if="property.allowsPets">Pet allowed </p>
          <p class="m-0" v-if="property.studio">Studio </p>
        </b-collapse>
      </div>
    </div>
  </div>



</template>



<script>

export default {



  props: ['property','nonApply'],
  methods: {
    setDesiredProperty(){
      this.$store.commit("SET_USER_DESIRED_PROPERTY",this.property);
    }
  },
  data() {
    return {
      visible: false
    }
  },
}

</script>

<style>

.card-img-top {
  width: 20rem;
  height: 13rem;
}

.builidng-card {
  height: fit-content;
}

.collapse-con {

  padding: 1rem;

}
.btn:focus {
  outline: none;
}

</style>