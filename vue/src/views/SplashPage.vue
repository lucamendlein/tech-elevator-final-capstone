<template>
  <div class="landing-page-con d-flex flex-md-column">
    <div class="container-fluid no-padding">
      <div class="row">
<!--        <div class="p-0">-->
          <img src="../../imgs/image.png" class="w-100 p-0">
<!--        </div>-->
        <div class="words">
          <h1 class="title display-3 text-light text-center carousel-caption h-75">Explore, Rent, Manage with Gotham City Real Estate </h1>
          <h4 class="headline display-5 text-light text-center carousel-caption h-20">Take the Riddle Out of Real Estate</h4>
           <!-- <router-link v-bind:to="{ name : 'properties'}" class="properties display-6 text-light text-center carousel-caption h-20"><h4>View Available Properties
          </h4></router-link> -->
        </div>
        <div class="jumbotron p-4 bg-light w-100" variant="info">
          <h1 class="display-4">Get Started!</h1>
          <p class="lead">Not all property managers are created equal. Gotham City Real Estate offers extra services and technology that set us apart.</p>
          <hr class="my-4">
          
          <p class="lead">
            <router-link v-bind:to="{ name : 'properties'}"><a class="btn btn-info btn-lg" role="button">View Available Properties</a></router-link>
          </p>
        </div>
        <!-- <div class="jumbotron p-4 bg-light w-100 ">
          <h1 class="display-4">Contact Us</h1>
          <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to
            featured content or information.</p>
          <hr class="my-4">
          <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
          <p class="lead">
            <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
          </p>
        </div> -->
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
  display: block;
  opacity: .8;
  bottom: 0px;
  right: 70px;
  height: 60%;

}



.login {
  font-size: 50px;
}

.register {
  font-size: 50px;
}

</style>