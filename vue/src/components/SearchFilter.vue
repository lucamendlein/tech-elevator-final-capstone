<template>
  <div>
    <form v-on:submit.prevent="setFilters">
      <table id="filterTable">
        <thead>
          <tr>
            <th>District</th>
            <th># of Bedrooms</th>
            <th># of Bathrooms</th>
            <th>Pets Allowed?</th>
          </tr>
          </thead>
          <tbody>
          <td>
<select id="district" v-model="selectedDistrict">
      <option value="">All Districts</option>
      <option v-for="district in districtList" :key="district" :value="district">{{district}}</option>
    </select>
            </td>
            <td>
               <select id="bedrooms" v-model="selectedBedrooms">
      <option value=""># of Bedrooms</option>
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5+">5+</option>
      </select>
              </td>
              <td>
               <select id="bedrooms" v-model="selectedBathrooms">
      <option value=""># of Bathrooms</option>
      <option value="1">1</option>
      <option value="1.5">1.5</option>
      <option value="2">2</option>
      <option value="2.5">2.5</option>
      <option value="3">3</option>
      <option value="3.5">3.5</option>
      <option value="4+">4+</option>
      </select>
              </td>
          <td>
            <select id="pet-friendly" v-model="selectedPets">
              <option value="">---------------</option>
              <option value="pets-allowed">Pets Allowed</option>
              <option value="pets-not-allowed">Pets Not Allowed</option>
              </select>
            </td>
            </tbody>
      </table>
      <input type="submit" value="Search">
      
      </form>
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
      selectedPets: this.$store.state.filterPropertyPets
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
    setFilters() {
      this.$store.commit('UPDATE_DISTRICT_FILTER', this.selectedDistrict)
      this.$store.commit('UPDATE_BEDROOM_FILTER', this.selectedBedrooms)
      this.$store.commit('UPDATE_BATHROOM_FILTER', this.selectedBathrooms)
      this.$store.commit('UPDATE_PET_FILTER', this.selectedPets)
    }

  }

}

</script>


<style>

</style>