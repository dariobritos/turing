package org.proygrad.turing.rest.controller;

import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.api.user.UserTO;
import org.proygrad.turing.service.nontransactional.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public UserTO getUser(@RequestParam("id") String id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestBody UserTO userTO) {

        return userService.addUser(userTO);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PATCH)
    public String updateUser(@RequestBody UserTO userTO) {

        return userService.updateUser(userTO);
    }

    @RequestMapping(value = "/user/{id}/scenario", method = RequestMethod.GET)
    public List<ScenarioTO> getUserScenario(@RequestParam("id") String id) {
        return userService.getUserScenario(id);
    }
}
