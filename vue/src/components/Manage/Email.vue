<template>
  <form class="contact-form" @submit.prevent="sendEmail">

    <div>
      <label>Name</label>
      <input type="text" name="user_name">
    </div>

    <div>
      <label>Email</label>
      <input type="email" name="user_email">

    </div>

    <div>
      <label>Message</label>
      <textarea name="message"></textarea>
    </div>

    <input type="submit" value="Send">
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