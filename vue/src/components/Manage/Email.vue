<template>
  <div class="d-flex flex-row h-100 w-100">
    <div class="side-bar">
       <Sidebar :options="side_bar_options"/>
      </div>
      <div class="right-side">
    <div :class="'m-1 alert alert-success alert-dismissible  '  + (isSubmitted ? 'show' :'hide') " role="alert">
      Email sent Successfully!
    </div>
    <form class="contact-form" @submit.prevent="sendEmail">
      <div class="form">
        <div class="col-md-6 col-md-12 p-lg-5">

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
  </div>
</template>


<script>
import emailjs from 'emailjs-com';
import Sidebar from "@/components/Navigation/Sidebar";

export default {
  name: 'email',
  components: {Sidebar},
  data() {
    return {
      isSubmitted: false,
      side_bar_options:{
        title: "Manage",
        links: [
          {
            name: 'View Tenants',route : '/tenants'
          },
          {
            name: 'Add Property',route : '/add_property'
          },
          {
            name: 'Send Email',route : '/email'
          },

        ]
      }

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
  margin-left: auto;
  width: 500px;


}
</style>
