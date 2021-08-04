<template>
  <div>
    <label for="District"> Choose District</label>
    <br>
    <select id="District" v-model="selectedDistrict" v-on:change="setStartFilter"> District
      <option value="">All Districts</option>
      <option v-for="district in districtList" :key="district" :value="district">{{district}}</option>
    </select>
  </div>

</template>

<script>
export default {
  name: "search-filter",
  data() {
    return {
      selectedDistrict: this.$store.state.filterProperty
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
    setStartFilter() {
      this.$store.commit('UPDATE_FILTER', this.selectedDistrict)
    }

  }

}

</script>


<style>

</style>