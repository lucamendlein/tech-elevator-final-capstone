<template>
  <div class="container">
       <div>
     <div class="words">
     <h1 class="headline">Gotham City Real Estate</h1>
     <nav>
    <router-link class="login" :to="{name: 'login'}"> Login</router-link>
     </nav>
     <nav>
    <router-link class="register"  :to="{name: 'register'}">Register new account </router-link>
     </nav>
  </div>
  </div>
      <img class="img" src="../../imgs/gothamskyline.jpg" alt="">
  </div>
</template>

<script>
export default {
    name: 'splash-page'

}
</script>

<style>
.container{
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas: 
    "headline img img" 
    "login img img"
    "register img img";
}

img {
     opacity: .3;
     bottom: 200px;
     right: 70px;
     height: 100%;
     
}
.words {
    position: absolute;
    top: 50%;
    left: 50%;
    color: black;
}

</style>