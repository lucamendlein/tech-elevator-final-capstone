<template>
<div class="side-bar-con">
  <div class="side-bar-title">
    <p class="display-6 p-3 border">{{options.title}}</p>

  </div>
  <div>
    <ul>
      <li class="side-bar-list p-1 m-1 border" v-for="link in options.links" :key="link.name">

        <router-link class="side-bar-link" :to="link.route" >{{link.name}}</router-link>

      </li>
    </ul>
  </div>



</div>
</template>

<script>
export default {
  name: "Sidebar",
  props:['options']
}
</script>

<style scoped>
ul{
  list-style: none;
  padding: 1rem 0.2rem;
}

.side-bar-list{

}
</style>