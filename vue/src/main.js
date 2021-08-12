import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import { BootstrapVue,IconsPlugin } from 'bootstrap-vue'
import FullpageModal from 'vue-fullpage-modal'


// Import Bootstrap an BootstrapVue CSS files (order is important)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import * as VueGoogleMaps from 'vue2-google-maps'


Vue.config.productionTip = false;
Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyDaANXtb--5mO-NGs8f9sIrfds2Du8Yhc4",
  }
})
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(FullpageModal)

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
