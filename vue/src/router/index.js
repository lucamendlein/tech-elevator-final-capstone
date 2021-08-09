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
      component: SplashPage,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/home',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      },

    },
    
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/properties",
      name: "properties",
      component: Properties,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/tenants",
      name: "manage",
      component: Manage,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/properties/:propertyId",
      name: "Rental",
      component: Rental,
      meta: {
        requiresAuth: false,
        requiresRegis:true
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
