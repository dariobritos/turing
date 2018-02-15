package org.proygrad.turing.service.nontransactional;

import org.apache.commons.lang.StringUtils;
import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.service.transactional.RequestCalculationTX;
import org.proygrad.turing.service.transactional.ScenarioServiceTX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScenarioService {

    @Autowired
    private ScenarioServiceTX scenarioServiceTX;

    @Autowired
    private RequestCalculationTX requestCalculationTX;


    public ScenarioTO getScenario(String id) {
        return scenarioServiceTX.getScenario(id);
    }

    public String addScenario(ScenarioTO scenarioTO) {
        String scenarioId = scenarioServiceTX.addScenario(scenarioTO);

        if(StringUtils.isNotBlank(scenarioId)){
            requestCalculationTX.addRequestCalculation(scenarioId);
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
        String scenarioId = scenarioServiceTX.updateOutputScenario(id, scenarioTO);
        if(StringUtils.isNotBlank(scenarioId)) {
            requestCalculationTX.setCompleteTask(scenarioId, true, true);
        }
        return scenarioId;
    }

}
