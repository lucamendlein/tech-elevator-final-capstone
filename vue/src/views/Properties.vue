<template>
  <div>
    <search-filter/>
    <property-list/>
  </div>
</template>

<script>

import SearchFilter from "@/components/SearchFilter";
import PropertyList from '../components/PropertyList.vue'


export default {

  name: "properties",
  components: {SearchFilter, PropertyList}

}
</script>

<style>

</style>
