package org.proygrad.turing.rest.controller;

import org.apache.log4j.Logger;
import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.service.nontransactional.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScenarioController {

    private static final Logger LOGGER = Logger.getLogger(ScenarioController.class);


    @Autowired
    private ScenarioService scenarioService;

    @RequestMapping(value = "/scenario/{id}", method = RequestMethod.GET)
    public ScenarioTO getScenario(@PathVariable("id") String id) {
        LOGGER.info("GET Scenario request received: " + id);
        return scenarioService.getScenario(id);
    }

    @RequestMapping(value = "/scenario", method = RequestMethod.POST)
    public String addScenario(@RequestBody ScenarioTO scenarioTO) {
        LOGGER.info("POST Scenario request received...");
        return scenarioService.addScenario(scenarioTO);
    }

    @RequestMapping(value = "/scenario/{id}", method = RequestMethod.PATCH)
    public String updateScenario(@PathVariable("id") String id, @RequestBody ScenarioTO scenarioTO) {
        LOGGER.info("PATCH Scenario request received: " + id);
        return scenarioService.updateScenario(id, scenarioTO);
    }

    @RequestMapping(value = "/scenario/{id}/input", method = RequestMethod.PATCH)
    public String updateInputScenario(@PathVariable("id") String id, @RequestBody ScenarioTO scenarioTO) {
        LOGGER.info("PATCH Scenario input request received: " + id);
        return scenarioService.updateInputScenario(id, scenarioTO);
    }

    @RequestMapping(value = "/scenario/{id}/output", method = RequestMethod.PATCH)
    public String updateOutputScenario(@PathVariable("id") String id, @RequestBody ScenarioTO scenarioTO) {
        LOGGER.info("PATCH Scenario output request received: " + id);
        return scenarioService.updateOutputScenario(id, scenarioTO);
    }

    @RequestMapping(value = "/scenario", method = RequestMethod.GET)
    public List<ScenarioTO> getUserScenario(@RequestParam(value = "user_id", required = true) String userId) {
        LOGGER.info("GET Scenarios request received...");
        return scenarioService.getUserScenario(userId);
    }
}
