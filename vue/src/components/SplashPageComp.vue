<template>
 <div>
   
 </div>
</template>
<script>
import SplashPage from '../views/SplashPage.vue'
export default {
  name: "splash-page-comp",
  mounted() {
    this.openModal();
  },
  methods: {
    openModal() {
      this.$FModal.show(
        {component: SplashPage  },
        { msg: "Welcome to Gotham City Real Estate"  }
      )
    }
  }
}
</script>
<style>
</style>