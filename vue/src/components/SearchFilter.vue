<template>
  <div>
    <select v-model="selectedDistrict" v-on:change="setStartFilter">
      <option value="">All</option>
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
    methods: {
      setStartFilter() {
        this.$store.commit('UPDATE_FILTER', this.selectedDistrict)
      }

    }

  }

}

</script>






<style>

</style>