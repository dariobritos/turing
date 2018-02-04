package org.proygrad.turing.service.transactional;


import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.persistence.dao.ScenarioDAO;
import org.proygrad.turing.persistence.entities.scenario.ScenarioEntity;
import org.proygrad.turing.service.transactional.mapper.ScenarioMapper;
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

    public ScenarioTO getScenario(String id) {
        return scenarioMapper.toTransferObject(scenarioDAO.load(id));
    }

    public String addScenario(ScenarioTO scenarioTO) {
        ScenarioEntity entity = scenarioMapper.toEntity(scenarioTO);

        scenarioDAO.save(entity);

        return entity.getId();
    }

    public String updateScenario(String id, ScenarioTO scenarioTO) {
        ScenarioEntity entity = scenarioDAO.load(id);

        if(entity!=null){
            entity.setType(scenarioTO.getType());
            entity.setUnitSystem(scenarioTO.getUnitSystem());

            return entity.getId();
        }
        return null;
    }

}
