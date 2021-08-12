<template>
  <div class="container">
    <div :class="'m-1 alert alert-success alert-dismissible  '  + (isSubmitted ? 'show' :'hide') " role="alert">
      Email sent Successfully!
    </div>
    <form class="contact-form p-2" @submit="sendEmail">


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
  </div>
</template>


<script>
import emailjs from 'emailjs-com';

export default {
  name: 'email',
  data() {
    return {
      isSubmitted: false,

    }
  },

  methods: {
    sendEmail: (e) => {

      emailjs.sendForm('service_9wt1nw9', 'template_zg1326b', e.target, 'user_dThbFBb0TWQ6SMTZYRhcb')
          .then((result) => {
            if(result.status ===200 || result.status ===201) {
              console.log('SUCCESS!', result.status, result.text);
              this.isSubmitted = true;

            }

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
  margin-left: auto;
  width: 80%;


}
</style>