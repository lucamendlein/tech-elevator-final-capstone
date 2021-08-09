<template>
  <div class="d-flex flex-row h-100 w-100">
    <div class="side-bar">

      <Sidebar :options="side_bar_options"/>
    </div>
    <div class="right-side">
      <AddProperty/>
      <TenantList/>
    </div>


  </div>

</template>

<script>
import AddProperty from "@/components/AddProperty";
import TenantList from "@/components/TenantList";
import Sidebar from "@/components/Sidebar";

export default {
  components: {Sidebar, AddProperty, TenantList},
  data() {
    return {
      side_bar_options:{
        title: "Manage",
        links: [
          {
            name: 'add-property',route : '/add-property'
          },
          {
            name: 'external contact',route : '/send-email'
          },
          {
            name: 'Tenants List',route : '/tenants-list'
          }
        ]
      }
    }
  }
}
</script>

<style>
.side-bar {
  background: white;
  width: 11%;
  height: 100%;
}


</style>