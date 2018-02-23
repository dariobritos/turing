package org.proygrad.turing.rest.controller;

import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.service.nontransactional.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScenarioController {

    @Autowired
    private ScenarioService scenarioService;

    @RequestMapping(value = "/scenario/{id}", method = RequestMethod.GET)
    public ScenarioTO getScenario(@PathVariable("id") String id) {

        return scenarioService.getScenario(id);
    }

    @RequestMapping(value = "/scenario", method = RequestMethod.POST)
    public String addScenario(@RequestBody ScenarioTO scenarioTO) {

        return scenarioService.addScenario(scenarioTO);
    }

    @RequestMapping(value = "/scenario/{id}", method = RequestMethod.PATCH)
    public String updateScenario(@PathVariable("id") String id, @RequestBody ScenarioTO scenarioTO) {

        return scenarioService.updateScenario(id, scenarioTO);
    }

    @RequestMapping(value = "/scenario/{id}/input", method = RequestMethod.PATCH)
    public String updateInputScenario(@PathVariable("id") String id, @RequestBody ScenarioTO scenarioTO) {

        return scenarioService.updateInputScenario(id, scenarioTO);
    }

    @RequestMapping(value = "/scenario/{id}/output", method = RequestMethod.PATCH)
    public String updateOutputScenario(@PathVariable("id") String id, @RequestBody ScenarioTO scenarioTO) {

        return scenarioService.updateOutputScenario(id, scenarioTO);
    }

    @RequestMapping(value = "/scenario", method = RequestMethod.GET)
    public List<ScenarioTO> getUserScenario(@RequestParam(value = "user_id", required = false) String userId) {
        return scenarioService.getUserScenario(userId);
    }
}
