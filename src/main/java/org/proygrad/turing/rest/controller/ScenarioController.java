package org.proygrad.turing.rest.controller;

import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.service.nontransactional.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ScenarioController {

    @Autowired
    private ScenarioService scenarioService;

    @RequestMapping(value = "/scenario/{id}", method = RequestMethod.GET)
    public ScenarioTO scenario(@RequestParam("id") UUID id) {
        return scenarioService.getScenario(id);
    }

    @RequestMapping(value = "/scenario", method = RequestMethod.POST)
    public UUID scenarioAdd(@RequestBody ScenarioTO scenarioTO) {

        return scenarioService.addScenario(scenarioTO);
    }

    @RequestMapping(value = "/scenario/{id}", method = RequestMethod.PATCH)
    public UUID scenarioUpd(@RequestParam("id") UUID id, @RequestBody ScenarioTO scenarioTO) {

        return scenarioService.updateScenario(id, scenarioTO);
    }


}
