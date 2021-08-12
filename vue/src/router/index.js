import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import SplashPage from '../views/SplashPage.vue'
import Properties from '../views/Properties.vue'
import Manage from '../views/Manage.vue'
import Rental from '../views/Rental.vue'
import TenantHome from '../views/TenantHome.vue'
import Navbar from "@/components/Navigation/Navbar";
import AddProperty from "@/components/Application/AddProperty";
import ServiceRequest from "@/components/ServiceRequest";
import Email from "@/components/Manage/Email";
import PayRent from "../components/PayRent"


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [

    {
      path: '/',
      name: 'splash-page',
      components: {navigation: Navbar, default: SplashPage},
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/home',
      name: 'home',
      components: {navigation: Navbar, default: Home},
      meta: {
        requiresAuth: true
      },

    },
    
    {
      path: "/login",
      name: "login",
      components: {navigation: Navbar, default: Login},
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      components: {navigation: Navbar, default: Logout},
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      components: {navigation: Navbar, default: Register},
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/properties",
      name: "properties",
      components: {navigation: Navbar, default: Properties},
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/tenants",
      name: "manage",
      components: {navigation: Navbar, default: Manage},
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/properties/:propertyId",
      name: "Rental",
      components: {navigation: Navbar, default: Rental},
      meta: {
        requiresAuth: false,
        requiresRegis:true
      }
    },
    {
      path: "/tenant-home",
      name: "tenant-home",
      components: {navigation: Navbar, default: TenantHome},
      meta: {
        requiresAuth: true,
      }
    },
    {
      path: "/add_property",
      name: "add_property",
      components: {navigation: Navbar, default: AddProperty},
      meta: {
        requiresAuth: true,
      }
    },
    {
      path: "/work-orders",
      name: "service-request",
      components: {navigation: Navbar, default:ServiceRequest},
      meta: {
        requiresAuth: true,
      }
    },
    {
      path: "/tenants/rent",
      name: "pay-rent",
      components: {navigation: Navbar, default: PayRent},
      meta: {
        requiresAuth: true,
      }
    },
    {
      path: "/email",
      name: "email",
      components: {navigation: Navbar, default:Email},
      meta: {
        requiresAuth: true,
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
 // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  const requiresRegis= to.matched.some(x => x.meta.requiresRegis);

  //If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  }else if(requiresRegis && store.state.token === ''){
    next("/register")
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
