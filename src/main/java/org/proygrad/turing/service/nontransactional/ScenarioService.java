package org.proygrad.turing.service.nontransactional;

import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.service.transactional.ScenarioServiceTX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ScenarioService {

    @Autowired
    private ScenarioServiceTX scenarioServiceTX;


    public UUID addScenario(ScenarioTO scenarioTO) {
        return scenarioServiceTX.addScenario(scenarioTO);
    }

    public ScenarioTO getScenario(UUID id) {
        return scenarioServiceTX.getScenario(id);
    }

    public UUID updateScenario(UUID id, ScenarioTO scenarioTO) {
        return scenarioServiceTX.updateScenario(id, scenarioTO);
    }
}
