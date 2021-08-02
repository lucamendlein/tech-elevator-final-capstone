<template>
  <div id="app">

    <div id="nav">
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <a class="navbar-brand mx-2" href="#">GOTHAM</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end p-2" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item ">
                <router-link class="nav-link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Manage</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Pricing</a>
              </li>
              <li class="nav-item">
                <router-link class=" btn btn-outline-secondary nav-link" v-bind:to="{ name: 'logout' }" >Logout</router-link>
              </li>
            </ul>
          </div>
        </nav>

    </div>
    <router-view />
  </div>
</template>
<script>
export default {
}
</script>

<style lang="scss">

</style>