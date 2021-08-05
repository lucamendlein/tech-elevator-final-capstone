package com.techelevator.controller;

import com.techelevator.dao.PropertyDAO;
import com.techelevator.model.Property;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@CrossOrigin
public class PropertyController {
    private PropertyDAO propertyDAO;

    public PropertyController(PropertyDAO propertyDAO) {
        this.propertyDAO = propertyDAO;
    }

    @RequestMapping( path = "/properties", method = RequestMethod.GET)
    @ResponseBody
    public List<Property> propertyList(){
        return propertyDAO.propertyList();
    }

    @RequestMapping(path = "/manage", method = RequestMethod.POST)
    public Property createProperty(@RequestBody Property property, Principal principal) {
         propertyDAO.createProperty(property, principal.getName());

        return property;

    }

}
