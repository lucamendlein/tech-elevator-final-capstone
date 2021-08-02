<template>
  <div class="landing-page-con d-flex flex-md-column">


    <div class="jumbotron p-4 bg-light w-100 ">
      <h1 class="display-4">Hello, world!</h1>
      <img :src="home_image">
      <p class="lead">
        <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
      </p>
    </div>
    <div class="jumbotron p-4 bg-primary w-100 ">
      <h1 class="display-4">Hello, world!</h1>
      <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to
        featured content or information.</p>
      <hr class="my-4">
      <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
      <p class="lead">
        <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
      </p>
    </div>

  </div>
</template>

<script>
import home_image from '../../images/building_image.jpeg';
export default {
  name: "splash-page-comp",
  data(){
    return {
      home_image: home_image
    }
  }
}
</script>
<style>

.landing-page-con {
  display: flex;
  flex-direction: row;
}


</style>

