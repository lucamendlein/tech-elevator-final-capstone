<template>


  <div v-on:loaded="openModal" >

     <div>
     <h1>Gotham City Real Estate</h1>
     <nav>
    <router-link :to="{name: 'login'}"> Login</router-link>
     </nav>
     <nav>
    <router-link :to="{name: 'register'}">Register new account </router-link>
     </nav>
  </div>
  </div>
</template>

<script>
import SplashPage from '../views/SplashPage.vue'
export default {
  name: "splash-page-comp",

  methods: {
    openModal() {
      this.$FModal.show(
        {component: SplashPage  },
        { msg: "Welcome to Gotham CIty Real Estate"  }
      )
    }
  }
}
</script>



<style>

</style>
