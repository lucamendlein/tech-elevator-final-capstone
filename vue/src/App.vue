<template>
  <div id="app" class="background">
    <div id="nav" class="page-nav-bar">
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <router-link class="navbar-brand mx-2" v-bind:to="{ name: 'splash-page'} " href="#">GOTHAM CITY REAL ESTATE</router-link>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end p-2" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item ">
                <router-link v-bind:to="{name: 'splash-page'}" class="nav-link" >Home</router-link>
              </li>
              <li class="nav-item">
                <router-link v-bind:to="{name: 'login'}" v-if="!$store.state.token" class="nav-link">Login</router-link>
              </li>
              <li class="nav-item">
                <router-link v-bind:to="{name: 'register'}" class="nav-link" v-if="!$store.state.token">Register</router-link>
              </li>
              <li class="nav-item">
                <router-link v-bind:to="{name: 'manage'}" class="nav-link" v-if="$store.state.token != ''">Manage</router-link>
                </li>
                <li class="nav-item">
                <router-link v-bind:to="{name: 'tenant-home'}" class="nav-link" v-if="$store.state.token != ''">My Account</router-link>
                </li>
              <li class="nav-item">
                <router-link class=" btn btn-outline-secondary nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
              </li>
            </ul>
          </div>
        </nav>
    </div>
    <main class="main">
      <router-view />
    </main>

  </div>
</template>
<script>
export default {
}
</script>
<style>

#app{
  display: flex;
  flex-direction: column;
  height: 100vh;
}
.page-nav-bar{
  position: sticky;
  top:0;
  z-index: 999;
}

.main{
  flex: 1 1 0;
  background-color: #f1f1f1;
}

</style>