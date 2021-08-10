<template>
  <div>
    <search-filter/>
    <property-list/>
  </div>
</template>

<script>

import SearchFilter from "@/components/Property/PropertyFilter";
import PropertyList from '../components/Property/PropertyList.vue'


export default {

  name: "properties",
  components: {SearchFilter, PropertyList}

}
</script>

<style>

</style>
