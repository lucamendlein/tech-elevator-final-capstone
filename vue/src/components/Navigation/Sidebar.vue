<template>
  <div class="side-bar-con">
    <div class="side-bar-title">
      <p class="side-bar-title display-6 p-3 border-bottom ">{{ options.title }}</p>

    </div>
    <div>
      <ul>
        <li :class="{
                  'side-bar-list':true,
                  'm-1':true,
                  'p-1':true,
                  'active': $route.path===link.route
                        }" v-for="link in options.links" :key="link.name">


          <router-link class="side-bar-link" :to="link.route">{{ link.name }}</router-link>

        </li>
      </ul>
    </div>


  </div>
</template>

<script>
export default {
  name: "Sidebar",
  props: ['options']
}
</script>

<style scoped>
ul {
  list-style: none;
  padding: 1rem 0.2rem;
}

.side-bar-list, .side-bar-title {
  overflow: hidden;
  text-overflow: ellipsis;
}

.side-bar-list {
  text-align: left;
  padding-left: 1rem !important;

}

.active {
  background: #f1f1f1;
  border-left: 2px red;
  text-decoration: none !important;
  position: relative;
  color: blue !important;
}

.active::before {
  content: "";
  position: absolute;
  left: 0px;
  width: 3px;
  height: 100%;
  background: #0066ff;
  z-index: 999;
}

a {
  text-decoration: none !important;
  color: #502828 ;
}
.active >a {
  color: #0066ff !important;
}
</style>