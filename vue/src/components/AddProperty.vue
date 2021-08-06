<template>
  <div>
    <div v-show="!showForm" class="form-group">
      <a href="#" v-on:click.prevent="showForm = true">Add Property</a>
    </div>
     <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
    <form v-if="showForm" @submit.prevent="submitForm" class="propertyForm">
       <div class="form-group">
        <label for="address-line-1">Address Line 1: </label>
        <input id="address-line-1" type="text" class="form-control" v-model="property.addressLine1">
      </div>
      <div class="form-group">
        <label for="address-line-2">Address Line 2: </label>
        <input id="address-line-2" type="text" class="form-control" v-model="property.addressLine2">
      </div>
      <div class = "form-group">
        <label for="district">District: </label>
        <input id="district" type="text" class="form-control" v-model="property.district">
      </div>
      <div class = "form-group">
        <label for="square-footage">Square Ft: </label>
        <input id="square-footage" type="number" class="form-control" v-model="property.squareFootage">
      </div>
      <div class = "form-group">
        <label for="bedrooms">Bedrooms: </label>
        <input id="bedrooms" type="number" class="form-control" v-model="property.bedrooms">
      </div>
      <div class = "form-group">
        <label for="bathrooms">Bathrooms: </label>
        <input id="bathrooms" type="number" class="form-control" v-model="property.bathrooms">
      </div>
      <div class = "form-group">
        <label for="price">Price per Month: </label>
        <input id="price" type="number" class="form-control" v-model="property.price">
      </div>
      <div class = "form-group">
        <input type="checkbox" for="allows-pet" v-model="property.allowsPets">Allows Pets?
      </div>
        <div class = "form-group">
          <label for="image-url">Image URL: </label>
          <input id="image-url" type="text" class ="form-control" v-model="property.imageUrl">
        </div>
        <div class = "form-group">
          <input type="checkbox" for="is-studio" v-model="property.isStudio">Studio? 
        </div>
        <div class = "form-group">
          <input type="checkbox" for="is-available" v-model="property.isAvailable">Available? 
        </div>
       <button class="btn btn-primary">Submit</button>
    </form>
  </div>

</template>


<script>
import PropertyService from "@/services/PropertyService";

export default {
  name: "add-property",
  //  props: {
  //   propertyID: {
  //     type: Number,
  //     default: 0
  //   }
  // },
  data(){
    return {
      showForm: false,
      property: {},
      errorMsg: "",
    };
  },
  methods: {
    submitForm() {
      // const newProperty = {
      //   addressLine1: this.property.addressLine1,
      //   addressLine2: this.property.addressLine2,
      //   district: this.property.district,
      //   squareFootage: this.property.squareFootage,
      //   bedrooms:this.property.bedrooms,
      //   bathrooms: this.property.bathrooms,
      //   price: this.property.price,
      //   allowsPets: this.property.allowsPets,
      //   imageUrl: this.property.imageUrl,
      //   isStudio:this.property.isStudio,
      //   isAvailable:this.property.isAvailable
      // };
        
        PropertyService.addProperty(this.property)
          .then(response => {
            
            if (response.status === 200 || response.status === 201) {
              alert("Property successfully added")
              console.log(response.data)
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "adding");
          });
    //   } else {
        
    //     newProperty.id = this.propertyId;
    //     newProperty.addressLine1 = this.property.addressLine1;
    //     newProperty.addressLine2 = this.property.addresLine2;
    //     newProperty.district = this.property.date;
    //     newProperty.squareFootage = this.property.squareFootage;
    //     newProperty.bedrooms = this.property.bedrooms;
    //     newProperty.bathrooms = this.property.bathrooms;
    //     newProperty.price = this.property.price;
    //     newProperty.allowsPets = this.property.allowsPets;
    //     newProperty.imageUrl = this.property.imageUrl;
    //     newProperty.isStudio = this.property.isStudio;
    //     newProperty.isAvailable = this.property.isAvailable;

    //     PropertyService
    //       .updateProperty(newProperty)
    //       .then(response => {
    //         if (response.status === 200) {
    //           this.$router.push(`/properties/${newProperty.propertyId}`);
    //         }
    //       })
    //       .catch(error => {
    //         this.handleErrorResponse(error, "updating");
    //       });
       
     },
    //  cancelForm() {
    //   this.$router.push(`/properties/${this.$route.params.propertyID}`);
    // },
    handleErrorResponse(error, verb) {
      if (error.response) {
        this.errorMsg =
          "Error " + verb + " property. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) {
        this.errorMsg =
          "Error " + verb + " property. Server could not be reached.";
      } else {
        this.errorMsg =
          "Error " + verb + " property. Request could not be created.";
      }
    }
  },
  // created() {
  //     PropertyService
  //       .getProperties(this.propertyID)
  //       .then(response => {
  //         this.property = response.data;
  //       })
  //       .catch(error => {
  //         if (error.response && error.response.status === 404) {
  //           alert(
  //             "Property not available. This property may have been deleted or you have entered an invalid property ID."
  //           );
  //           this.$router.push("/");
  //         }
  //       });
  //   }
  };

  

</script>


<style>
.propertyForm {
  padding: 10px;
  margin-bottom: 10px;
}
.form-group {
  margin-bottom: 10px;
  margin-top: 10px;
}
label {
  display: inline-block;
  margin-bottom: 0.5rem;
}
.form-control {
  display: block;
  width: 80%;
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 3px solid #ced4da;
  border-radius: 0.25rem;
}
textarea.form-control {
  height: 75px;
  font-family: Arial, Helvetica, sans-serif;
}
select.form-control {
  width: 20%;
  display: inline-block;
  margin: 10px 20px 10px 10px;
}
.status-message {
  display: block;
  border-radius: 5px;
  font-weight: bold;
  font-size: 1rem;
  text-align: center;
  padding: 10px;
  margin-bottom: 10px;
}
.status-message.success {
  background-color: #90ee90;
}
.status-message.error {
  background-color: #f08080;
}
</style>