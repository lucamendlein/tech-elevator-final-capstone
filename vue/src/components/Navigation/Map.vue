<template>

  <div>
    <GmapMap
        :center="{lat:10, lng:10}"
        :zoom="7"
        map-type-id="terrain"
        style="width: 500px; height: 100%"
    >
    </GmapMap>

  </div>
</template>

<script>
export default {
  name: "Map",

}
</script>

<style scoped>

</style>

