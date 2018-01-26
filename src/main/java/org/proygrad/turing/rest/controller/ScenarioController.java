package org.proygrad.turing.rest.controller;

import org.proygrad.turing.api.ScenarioTO;
import org.proygrad.turing.service.nontransactional.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ScenarioController {

    @Autowired
    ScenarioService scenarioService;

    @RequestMapping(value = "/scenario", method = RequestMethod.GET)
    public List<ScenarioTO> scenario() {
        return scenarioService.getScenario();
    }

    @RequestMapping(value = "/scenario", method = RequestMethod.POST)
    public UUID scenarioAdd(@RequestBody ScenarioTO scenarioTO) {

        return scenarioService.addScenario(scenarioTO);
    }

}
