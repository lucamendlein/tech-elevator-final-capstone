<template>
  <div class="landing-page-con d-flex flex-md-column">
    <div class="container-fluid no-padding">
      <div class="row">
<!--        <div class="p-0">-->
          <img src="../../imgs/gothamskyline.jpg" class="w-100 p-0">
<!--        </div>-->
        <div class="words">
          <h1 class="title text-light text-center">Explore, Rent, Manage with GOTHAM - </h1>
          <h2 class="text-light text-center">Take the Riddle Out of Real Estate</h2>
          <router-link v-bind:to="{ name : 'properties'}" class="properties text-light">View Available Properties
          </router-link>
        </div>
        <div class="jumbotron p-4 bg-light w-100 ">
          <h1 class="display-4">Get Started!</h1>
          <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to
            featured content or information.</p>
          <hr class="my-4">
          <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
          <p class="lead">
            <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
          </p>
        </div>
        <div class="jumbotron p-4 bg-light w-100 ">
          <h1 class="display-4">Contact Us</h1>
          <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to
            featured content or information.</p>
          <hr class="my-4">
          <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
          <p class="lead">
            <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'splash-page',
  data() {
    return {};
  }

}
</script>

<style>


img {
  opacity: .8;
  bottom: 0px;
  right: 70px;
  height: 60%;

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
  font-size: 30px;
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