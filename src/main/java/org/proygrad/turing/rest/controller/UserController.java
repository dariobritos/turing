package org.proygrad.turing.rest.controller;

import org.apache.log4j.Logger;
import org.proygrad.turing.api.user.UserTO;
import org.proygrad.turing.service.nontransactional.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public UserTO getUser(@PathVariable("id") String id) {
        LOGGER.info("GET User request received: " + id);
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestBody UserTO userTO) {
        LOGGER.info("POST User request received...");
        return userService.addUser(userTO);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") String id, @RequestBody UserTO userTO) {
        LOGGER.info("PATCH User request received: " + id);
        return userService.updateUser(id, userTO);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserTO getUserByEmail(@RequestParam(value = "email") String email) {
        LOGGER.info("GET User by email request received: " + email);
        return userService.getUserByEmail(email);
    }

}
