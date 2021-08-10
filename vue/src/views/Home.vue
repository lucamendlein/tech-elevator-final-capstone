<template>
  <div class="home">
    <h1>Home</h1>

    <p>You must be authenticated to see this</p>
    <div>

      <Map/>
  </div>

  </div>
  
  
</template>

<script>


import Map from "@/components/Navigation/Map";
export default {
  name: "home",
  components: {Map}

};
</script>
