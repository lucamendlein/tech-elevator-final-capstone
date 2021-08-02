<template>
  <div class="home">
    <h1>Home</h1>
<<<<<<< HEAD
  
    
=======
    <p>You must be authenticated to see this</p>
    <div>
      <splash-page-comp v-if="$store.state.token=''"/>
    </div>
>>>>>>> 9e4a95a6c9cf32266d558f9c4b536115a5f18d29
  </div>
  
  
</template>

<script>

<<<<<<< HEAD
=======
import SplashPageComp from "@/components/SplashPageComp";
>>>>>>> 9e4a95a6c9cf32266d558f9c4b536115a5f18d29
export default {
  name: "home",
  components: {SplashPageComp}

};
</script>
