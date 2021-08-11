<template>
  <div class="d-flex flex-row h-100 w-100">
    <div class="side-bar">

      <Sidebar :options="side_bar_options"/>
      <email />
    </div>
    <div class="right-side">
      <TenantList/>
    </div>
    <div>
      
    </div>


  </div>

</template>

<script>
import TenantList from "@/components/Tenant/TenantList";
import Sidebar from "@/components/Navigation/Sidebar";
import Email from '../components/Manage/Email.vue';



export default {
  components: {Sidebar, TenantList, Email},
  data() {
    return {
      side_bar_options:{
        title: "Manage",
        links: [
          {
            name: 'Tenants',route : '/tenants'
          },
          {
            name: 'Add Property',route : '/add_property'
          },
          {
            name: 'email',route : '/email'
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
  width: 200px;
  height: 100%;
}


</style>