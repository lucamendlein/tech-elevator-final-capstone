<template>
  <div class="home">
    <h1>Home</h1>

    <p>You must be authenticated to see this</p>
    <div>
      <splash-page-comp v-if="$store.state.token=''"/>
  </div>

  </div>
  
  
</template>

<script>


import SplashPageComp from "@/components/SplashPageComp";
export default {
  name: "home",
  components: {SplashPageComp}

};
</script>
