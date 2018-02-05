package org.proygrad.turing.service.nontransactional;

import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.rest.client.EinsteinClient;
import org.proygrad.turing.service.transactional.ScenarioServiceTX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScenarioService {

    @Autowired
    private ScenarioServiceTX scenarioServiceTX;

    @Autowired
    private EinsteinClient einsteinClient;

    public ScenarioTO getScenario(String id) {
        return scenarioServiceTX.getScenario(id);
    }

    public String addScenario(ScenarioTO scenarioTO) {
        String scenarioId = scenarioServiceTX.addScenario(scenarioTO);
        if(scenarioId!=null && !scenarioId.isEmpty()){
            scenarioTO.setId(scenarioId);
            String requestCalculationId = einsteinClient.postCalculation(scenarioTO);
            //TODO: deberia Guardarlo ser bandera para etc.

        }
        return scenarioId;
    }

    public String updateScenario(String id, ScenarioTO scenarioTO) {
        return scenarioServiceTX.updateScenario(id, scenarioTO);
    }

    public String updateInputScenario(String id, ScenarioTO scenarioTO) {
        return scenarioServiceTX.updateInputScenario(id, scenarioTO);
    }

    public String updateOutputScenario(String id, ScenarioTO scenarioTO) {
        return scenarioServiceTX.updateOutputScenario(id, scenarioTO);
    }

}
