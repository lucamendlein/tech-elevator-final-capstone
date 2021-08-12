<template>

  <div>
    <div class="sidenav">
      <div class="login-main-text d-flex flex-column justify-content-center align-items-center">

        <img class="logo-img" :src="logo">
        <div class="my-3">
          <h2>Gotham City<br> Real Estate</h2>
        </div>


      </div>
    </div>
    <div class="main">
      <div class="col-md-6 col-sm-12">
        <div class="login-form">
          <b-form class="form-signin p-2" @submit.prevent="login">
            <div
                class="alert alert-danger"
                role="alert"
                v-if="invalidCredentials"
            >Invalid username and password!
            </div>
            <div
                class="alert alert-success p-5"
                role="alert"
                v-if="this.$route.query.registration"
            >Thank you for registering, please sign in.
            </div>
            <div class="py-2">
              <label for="username" class="sr-only input-group-lg">Username</label>
              <input
                  type="text"
                  id="username"
                  class="form-control"
                  placeholder="Username"
                  v-model="user.username"
                  required
                  autofocus
              />
              <label for="password" class="sr-only">Password</label>
              <input
                  type="password"
                  id="password"
                  class="form-control"
                  placeholder="Password"
                  v-model="user.password"
                  required
              />
            </div>

            <button type="submit" class="btn btn-black">Sign in</button>
            <router-link :to="{ name: 'register' }">
              <button type="submit" class="btn btn-secondary mx-3">Register</button>
            </router-link>
            <div>

            </div>
          </b-form>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
import authService from "../services/AuthService";
import logo from '../../imgs/logo.svg'

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      logo: logo,
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
          .login(this.user)
          .then(response => {
            if (response.status == 200) {
              this.$store.commit("SET_AUTH_TOKEN", response.data.token);
              this.$store.commit("SET_USER", response.data.user);
              this.$router.push("/");
            }
          })
          .catch(error => {
            const response = error.response;

            if (response.status === 401) {
              this.invalidCredentials = true;
            }
          });
    }
  }
};
</script>
<style scoped>

body {
  font-family: "Lato", sans-serif;
}


.main-head {
  height: 150px;
  background: #FFF;

}

.sidenav {
  height: 100%;
  background-color: #000;
  overflow-x: hidden;
  padding-top: 20px;
}


.main {
  padding: 0px 10px;
}

@media screen and (max-height: 450px) {
  .sidenav {
    padding-top: 15px;
  }
}

@media screen and (max-width: 450px) {
  .login-form {
    margin-top: 10%;
  }

  .register-form {
    margin-top: 10%;
  }
}

@media screen and (min-width: 768px) {
  .main {
    margin-left: 57%;
  }

  .sidenav {
    width: 40%;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
  }

  .login-form {
    margin-top: 80%;
  }

  .register-form {
    margin-top: 20%;
  }
}


.login-main-text {
  margin-top: 20%;
  padding: 60px;
  color: #fff;
}

.login-main-text h2 {
  font-weight: 300;
}

.btn-black {
  background-color: #000 !important;
  color: #fff;
}

.logo-img {
  width: 90px;
}
</style>
