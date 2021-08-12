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


          <b-form class="form-register" @submit.prevent="register">
            <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
            <div class="alert alert-danger" role="alert" v-if="registrationErrors">
              {{ registrationErrorMsg }}
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
              <label for="ConfirmPassword" class="sr-only">Password</label>
              <input
                  type="password"
                  id="confirmPassword"
                  class="form-control"
                  placeholder="Confirm Password"
                  v-model="user.confirmPassword"
                  required
              />
            </div>


            <button type="submit" class="btn btn-black">Create Account</button>
            <router-link :to="{ name: 'login' }"> <button type="submit" class="btn btn-secondary mx-3">Have an Account?</button></router-link>
            <div>

            </div>
          </b-form>
        </div>
      </div>
    </div>


</div>
</template>

<script>
import authService from '../services/AuthService';
import logo from '../../imgs/logo.svg'

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      logo:logo,
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

body {
  font-family: "Lato", sans-serif;
}



.main-head{
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
  .sidenav {padding-top: 15px;}
}

@media screen and (max-width: 450px) {
  .login-form{
    margin-top: 10%;
  }

  .register-form{
    margin-top: 10%;
  }
}

@media screen and (min-width: 768px){
  .main{
    margin-left: 57%;
  }

  .sidenav{
    width: 40%;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
  }

  .login-form{
    margin-top: 80%;
  }

  .register-form{
    margin-top: 20%;
  }
}


.login-main-text{
  margin-top: 20%;
  padding: 60px;
  color: #fff;
}

.login-main-text h2{
  font-weight: 300;
}

.btn-black{
  background-color: #000 !important;
  color: #fff;
}

.logo-img{
  width: 90px;
}
</style>
