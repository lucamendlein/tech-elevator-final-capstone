<template>
  <div class="d-flex flex-row h-100 w-100">
    <div class="side-bar">

      <Sidebar :options="side_bar_options"/>

    </div>
    <div class="right-side">
      <img src="'../../imgs/logo.svg'">
    </div>
    <div>

    </div>


  </div>

</template>


<script>



import Sidebar from "@/components/Navigation/Sidebar";
export default {
  components: {Sidebar},
  data() {
    return {
      side_bar_options:{
        title: "Dashboard",
        links: [
          {
            name: 'Pay Rent',route : '/tenants/rent'
          },
          {
            name: 'Service Request',route : '/work-orders'
          },


        ]
      }
    }
  }
}
</script>

<style>
.side-bar {
  background: white;
  width: 400px;
  height: 100%;
}

</style>