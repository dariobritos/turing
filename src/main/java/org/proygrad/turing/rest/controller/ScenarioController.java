package org.proygrad.turing.rest.controller;

import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.service.nontransactional.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScenarioController {

    @Autowired
    private ScenarioService scenarioService;

    @RequestMapping(value = "/scenario/{id}", method = RequestMethod.GET)
    public ScenarioTO scenario(@RequestParam("id") String id) {
        return scenarioService.getScenario(id);
    }

    @RequestMapping(value = "/scenario", method = RequestMethod.POST)
    public String scenarioAdd(@RequestBody ScenarioTO scenarioTO) {

        return scenarioService.addScenario(scenarioTO);
    }

    @RequestMapping(value = "/scenario/{id}", method = RequestMethod.PATCH)
    public String scenarioUpd(@RequestParam("id") String id, @RequestBody ScenarioTO scenarioTO) {

        return scenarioService.updateScenario(id, scenarioTO);
    }


}
