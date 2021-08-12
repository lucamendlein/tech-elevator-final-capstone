<template>

  <div>

    <GmapMap
        :center="center"
        :zoom="16"
        map-type-id="terrain"
        style="width: 500px; height: 100%"
    >
      <GmapMarker
          :position="center"
      />
    </GmapMap>

  </div>
</template>

<script>
//import PropertyService from "@/services/PropertyService";


export default {
  name: "Map",
  //props:['location'],
  data() {
    return {
      markers: [],
      center: {lat:39.971686, lng:-82.763592}
    }
  },
  created() {
    //console.log(PropertyService.getGeoLocation(location))
  },

  methods: {

  }

}
</script>

<style scoped>

</style>

