<template>
  <div id="nav" class="page-nav-bar">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">


        <router-link class="navbar-brand mx-2 d-flex flex-row" v-bind:to="{ name: 'splash-page'} " href="#">
          <img class="mx-2" src="../../../imgs/logo.svg" width="30" height="30" alt="">
          <span>Gotham City Real Estate </span>
        </router-link>



      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse justify-content-end p-2" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item ">
            <router-link v-bind:to="{name: 'splash-page'}" class="nav-link">Home</router-link>
          </li>
          <li class="nav-item">
            <router-link v-bind:to="{name: 'login'}" v-if="!$store.state.token" class="nav-link">Login</router-link>
          </li>
          <li class="nav-item">
            <router-link v-bind:to="{name: 'register'}" class="nav-link" v-if="!$store.state.token">Register
            </router-link>
          </li>
          <li class="nav-item" v-if=" $store.state.token != ''">
            <router-link  v-if="$store.state.role.includes('OWNER')" v-bind:to="{name: 'manage'}" class="nav-link">Manage</router-link>
          </li>
          <li class="nav-item"  v-if="$store.state.token != ''">
            <router-link v-if="$store.state.role.includes('USER')" v-bind:to="{name: 'tenant-home'}" class="nav-link">My
              Account
            </router-link>
          </li>
          <li class="nav-item">
            <router-link class=" btn btn-outline-secondary nav-link" v-bind:to="{ name: 'logout' }"
                         v-if="$store.state.token != ''">Logout
            </router-link>
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: "Navbar"
}
</script>

<style scoped>
.page-nav-bar {
  position: sticky;
  top: 0;
  z-index: 999;
}
</style>