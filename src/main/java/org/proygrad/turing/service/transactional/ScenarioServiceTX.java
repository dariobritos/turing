package org.proygrad.turing.service.transactional;


import org.proygrad.turing.api.ScenarioTO;
import org.proygrad.turing.persistence.dao.ScenarioDAO;
import org.proygrad.turing.persistence.entities.ScenarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ScenarioServiceTX {

    @Autowired
    private ScenarioDAO scenarioDAO;

    @Autowired
    private ScenarioMapper scenarioMapper;

    public UUID addScenario(ScenarioTO scenarioTO) {
        ScenarioEntity entity = new ScenarioEntity();
        entity.setType(scenarioTO.getType());
        entity.setUnit(scenarioTO.getUnit());
        scenarioDAO.save(entity);

        return entity.getId();
    }

    public List<ScenarioTO> getScenario() {
        return scenarioDAO.readAll().stream().map(this.scenarioMapper::toTransferObject).collect(Collectors.toList());
    }
}
