package org.proygrad.turing.service.nontransactional;

import org.proygrad.turing.api.ScenarioTO;
import org.proygrad.turing.service.transactional.ScenarioServiceTX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ScenarioService {

    @Autowired
    ScenarioServiceTX scenarioServiceTX;


    public UUID addScenario(ScenarioTO scenarioTO) {
        return scenarioServiceTX.addScenario(scenarioTO);
    }

    public List<ScenarioTO> getScenario() {
        return scenarioServiceTX.getScenario();
    }
}
