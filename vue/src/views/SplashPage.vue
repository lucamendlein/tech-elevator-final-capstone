<template>
  <div class="container">
       <div>
         <img src="../../imgs/gothamskyline.jpg">
  </div>
  <div class="words">
    <h1 class="title">Explore, Rent, Manage with GOTHAM - </h1>
      <h2>Take the Riddle Out of Real Estate</h2>
    <router-link v-bind:to="{ name : 'PropertiesList'}" class="properties">View Available Properties</router-link>
    </div>
    
  </div>
</template>

<script>
export default {
    name: 'splash-page',
      data() {
    return {
      
    };
  }

}
</script>

<style>


img {
     opacity: .6;
     bottom: 200px;
     right: 70px;
     height: 100%;
     
}
.words {
    position: absolute;
    top: 20%;
    left: 10%;
    color: black;
}

.properties {
  position: relative;
  top: 100%;
  left: 1%;
  color: black;
  font-size: 20px;
}
.headline {
  font-size: 75px;
}
.login {
  font-size: 50px;
}

.register {
  font-size: 50px;
}

</style>