package org.proygrad.turing.service.transactional;


import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.persistence.dao.ScenarioDAO;
import org.proygrad.turing.persistence.entities.ScenarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ScenarioServiceTX {

    @Autowired
    private ScenarioDAO scenarioDAO;

    @Autowired
    private ScenarioMapper scenarioMapper;

    public String addScenario(ScenarioTO scenarioTO) {
        ScenarioEntity entity = scenarioMapper.toEntity(scenarioTO);

        scenarioDAO.save(entity);

        return entity.getId();
    }

    public ScenarioTO getScenario(String id) {
        return scenarioMapper.toTransferObject(scenarioDAO.load(id));
    }

    public String updateScenario(String id, ScenarioTO scenarioTO) {
        ScenarioEntity entity = scenarioDAO.load(id);

        if(entity!=null){
            entity.setType(scenarioTO.getType());
            entity.setUnit(scenarioTO.getUnit());

            return entity.getId();
        }
        return null;
    }

}
