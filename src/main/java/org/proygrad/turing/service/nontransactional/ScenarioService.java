package org.proygrad.turing.service.nontransactional;

import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.service.transactional.ScenarioServiceTX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScenarioService {

    @Autowired
    private ScenarioServiceTX scenarioServiceTX;

    public ScenarioTO getScenario(String id) {
        return scenarioServiceTX.getScenario(id);
    }

    public String addScenario(ScenarioTO scenarioTO) {
        return scenarioServiceTX.addScenario(scenarioTO);
    }

    public String updateScenario(String id, ScenarioTO scenarioTO) {
        return scenarioServiceTX.updateScenario(id, scenarioTO);
    }
}
