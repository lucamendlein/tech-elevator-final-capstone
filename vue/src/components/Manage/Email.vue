<template>
  <form class="contact-form p-2" @submit.prevent="sendEmail">
    <div :class="'m-1 alert alert-success alert-dismissible  '  + (isSubmitted ? 'show' :'hide') " role="alert">
      Property added Successfully!
      <button @click="isSubmitted=false" class="btn btn-outline-dark border-0 bg-transparent float-end"> x</button>
    </div>

    <div class="form">
    <div class="col-md-4 col-sm-12 p-lg-5">

    <div class="form-group">
      <label for="name">Name</label>
      <input name="user_name" type="text" class="form-control" id="name" placeholder="Name">
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input name="user_email" type="email" class="form-control" id="email" placeholder="Email">
    </div>
    <div class="form-group">
      <label for="message">Message</label>
      <textarea name="message" class="form-control" id="message" rows="3"></textarea>
    </div>
      <input type="submit" value="Send">
    </div>
    </div>
  </form>
</template>

<script>
import emailjs from 'emailjs-com';

export default {
    name: 'email',

  methods: {
    sendEmail: (e) => {
      emailjs.sendForm('service_9wt1nw9', 'template_zg1326b', e.target, 'user_dThbFBb0TWQ6SMTZYRhcb')
        .then((result) => {
            console.log('SUCCESS!', result.status, result.text);
        }, (error) => {
            console.log('FAILED...', error);
        });
    }
  }
}
</script>

<style>
.form {
  display: block;
  margin-left:auto;
  width: 80%;


}
</style>