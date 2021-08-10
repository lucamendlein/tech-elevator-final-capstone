<template>
  <div id="app" class="background">
    <router-view name="navigation"/>
    <main class="main">
      <router-view/>
    </main>
  </div>
</template>
<script>
export default {}
</script>
<style>
#app {
  display: flex;
  flex-direction: column;
  height: 100vh;
}



.main {
  flex: 1 1 0;
  background-color: #F1F1F1;
}
</style>