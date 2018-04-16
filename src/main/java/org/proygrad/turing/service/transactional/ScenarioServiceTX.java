package org.proygrad.turing.service.transactional;


import org.apache.log4j.Logger;
import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.persistence.dao.scenario.CommonItemDAO;
import org.proygrad.turing.persistence.dao.scenario.ParameterDAO;
import org.proygrad.turing.persistence.dao.scenario.ScenarioDAO;
import org.proygrad.turing.persistence.entities.scenario.CommonItemEntity;
import org.proygrad.turing.persistence.entities.scenario.ParameterEntity;
import org.proygrad.turing.persistence.entities.scenario.ScenarioEntity;
import org.proygrad.turing.service.transactional.mapper.CommonItemMapper;
import org.proygrad.turing.service.transactional.mapper.ParameterMapper;
import org.proygrad.turing.service.transactional.mapper.ScenarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScenarioServiceTX {

    private static final Logger LOGGER = Logger.getLogger(ScenarioServiceTX.class);

    @Autowired
    private ScenarioDAO scenarioDAO;

    @Autowired
    private ScenarioMapper scenarioMapper;

    @Autowired
    private ParameterMapper parameterMapper;

    @Autowired
    private ParameterDAO parameterDAO;

    @Autowired
    private CommonItemMapper commonItemMapper;

    @Autowired
    private CommonItemDAO commonItemDAO;

    public ScenarioTO getScenario(String id) {
        LOGGER.info("Reading scenario: " + id);
        return scenarioMapper.toTransferObject(scenarioDAO.load(id));
    }

    public String addScenario(ScenarioTO scenarioTO) {
        LOGGER.info("Saving scenario..");
        ScenarioEntity entity = scenarioMapper.toEntity(scenarioTO);
        scenarioDAO.save(entity);
        LOGGER.info("Scenario saved: "+ entity.getId());
        return entity.getId();
    }

    public String updateScenario(String id, ScenarioTO scenarioTO) {
        LOGGER.info("Updating scenario...");
        ScenarioEntity entity = scenarioDAO.load(id);
        LOGGER.info("Updating scenario not implemented...");
        if(entity!=null){
            return entity.getId();
        }
        return null;
    }

    public String updateInputScenario(String id, ScenarioTO scenarioTO) {
        ScenarioEntity entity = scenarioDAO.load(id);

        if(entity != null){
            entity.setType(scenarioTO.getType());
            entity.setUnitSystem(scenarioTO.getUnitSystem());

            entity.getParameters().forEach(o -> this.parameterDAO.delete(o.getId()));
            List<ParameterEntity> parameters = scenarioTO.getParameters().stream().map(this.parameterMapper::toEntity).collect(Collectors.toList());
            entity.setParameters(parameters);

            entity.getConfiguration().forEach(o -> this.commonItemDAO.delete(o.getId()));
            List<CommonItemEntity> configurations = scenarioTO.getConfiguration().stream().map(this.commonItemMapper::toEntity).collect(Collectors.toList());
            entity.setConfiguration(configurations);

            entity.setComments(scenarioTO.getComments());

            return entity.getId();
        }

        return null;
    }

    public String updateOutputScenario(String id, ScenarioTO scenarioTO) {
        ScenarioEntity entity = scenarioDAO.load(id);

        if(entity != null){


            entity.getOutput().clear();
            entity.getOutput().addAll(scenarioTO.getOutput().stream().map(this.commonItemMapper::toEntity).collect(Collectors.toList()));

            return entity.getId();
        }

        return null;
    }

    public List<ScenarioTO> getUserScenario(String userId) {
        LOGGER.info("Reading scenarios for user: " + userId);
        return scenarioDAO.readByUserId(userId).stream().map(this.scenarioMapper::toTransferObject).collect(Collectors.toList());
    }
}
