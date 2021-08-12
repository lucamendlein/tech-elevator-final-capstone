<template>
  <div>
    <div class="w-75 card d-flex flex-row flex-wrap justify-content-between">
      <div class="p-2 px-4">
        <label class="fw-bold">District: </label>
        <b-dropdown class="btn btn-outline-info border-0 bg-transparent text-info" :text="selectedDistrict ? selectedDistrict : 'Any'" block variant="outline-info" >
          <b-dropdown-item @click="setDistrict('')" class="border-bottom">All </b-dropdown-item>
          <b-dropdown-item @click=" setDistrict(district)" class="border-bottom" v-for="district in districtList" :key="district" href="#">{{district}}</b-dropdown-item>
        </b-dropdown>

      </div>
      <div class="p-2 px-4">
        <label class="fw-bold">Bedroom Size: </label>
        <b-dropdown class="btn btn-outline-info border-0 bg-transparent text-info" :text="selectedBedrooms ? selectedBedrooms : 'Any'" block variant="outline-info" >
          <b-dropdown-item @click="setBedroomSize('')" class="border-bottom">Any </b-dropdown-item>
          <b-dropdown-item @click="setBedroomSize(2)" class="border-bottom">2 </b-dropdown-item>
          <b-dropdown-item @click="setBedroomSize(3)" class="border-bottom">3 </b-dropdown-item>
          <b-dropdown-item @click="setBedroomSize(4)" class="border-bottom">4 </b-dropdown-item>

        </b-dropdown>

      </div>
      <div class="p-2 px-4">
        <label class="fw-bold">Bathroom Size: </label>
        <b-dropdown class="btn btn-outline-info border-0 bg-transparent text-info" :text="selectedBathrooms ? selectedBathrooms : 'Any'" block variant="outline-info" >
          <b-dropdown-item @click="setBathroomSize('')" class="border-bottom">Any </b-dropdown-item>
          <b-dropdown-item @click="setBathroomSize(1)" class="border-bottom">1 </b-dropdown-item>
          <b-dropdown-item @click="setBathroomSize(2)" class="border-bottom">2 </b-dropdown-item>
          <b-dropdown-item @click="setBathroomSize(3)" class="border-bottom">3 </b-dropdown-item>
          <b-dropdown-item @click="setBedroomSize(4)" class="border-bottom">4 </b-dropdown-item>

        </b-dropdown>

      </div>
      <div class="p-2 px-4">
        <label class="fw-bold">Price: </label>
        <b-dropdown class="btn btn-outline-info border-0 bg-transparent text-primary" :text="selectedPrice ? selectedPrice : 'Any'" block variant="outline-info" >
          <b-dropdown-item @click="setPropertyPrice(undefined)" class="border-bottom">Any </b-dropdown-item>
          <b-dropdown-item @click="setPropertyPrice(600)" class="border-bottom">$600 </b-dropdown-item>
          <b-dropdown-item @click="setPropertyPrice(800)" class="border-bottom">$800 </b-dropdown-item>
          <b-dropdown-item @click="setPropertyPrice(1000)" class="border-bottom">$1000 </b-dropdown-item>
          <b-dropdown-item @click="setPropertyPrice(1200)" class="border-bottom">$1200 </b-dropdown-item>

        </b-dropdown>

      </div>



    </div>
  </div>

  <!-- potential to change to form in order to add event listener to submit and update filters all at once -->

</template>

<script>
export default {
  name: "search-filter",
  data() {
    return {
      selectedDistrict: this.$store.state.filterPropertyDistrict,
      selectedBedrooms: this.$store.state.filterPropertyBedrooms,
      selectedBathrooms: this.$store.state.filterPropertyBathrooms,
      selectedPets: this.$store.state.filterPropertyPets,
      selectedPrice: this.$store.state.filterPropertyPrice
    }

  },
  computed: {
    districtList() {
      const districts = this.$store.state.properties.map(property => {
        return property.district;
      })
      const uniqueDistricts= [...new Set(districts)];

      return uniqueDistricts.sort();

    },


  },
  methods: {
    setDistrict(district){
      this.selectedDistrict=district;
      this.$store.commit('UPDATE_DISTRICT_FILTER', district)
    },
    setBedroomSize(size){
      this.selectedBedrooms=size;
      this.$store.commit('UPDATE_BEDROOM_FILTER', size)
    },
    setBathroomSize(size){
      this.selectedBathrooms=size;
      this.$store.commit('UPDATE_BATHROOM_FILTER', size)
    },
    setPetPermission(isAllowed){
      this.selectedPets=isAllowed;
      this.$store.commit('UPDATE_PET_FILTER', isAllowed)
    },
    setPropertyPrice(price){
      this.selectedPrice = price;
      this.$store.commit('UPDATE_PRICE_FILTER', price)

    }


  }

}

</script>


<style>

</style>