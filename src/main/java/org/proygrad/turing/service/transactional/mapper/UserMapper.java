package org.proygrad.turing.service.transactional.mapper;

import org.proygrad.turing.api.user.UserPreferencesTO;
import org.proygrad.turing.api.user.UserTO;
import org.proygrad.turing.persistence.entities.user.UserEntity;
import org.proygrad.turing.persistence.entities.user.UserPreferencesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    @Autowired
    private UserPreferencesMapper userPreferencesMapper;

    @Autowired
    private ScenarioMapper scenarioMapper;

    public UserEntity toEntity(UserTO data){
        UserEntity entity = new UserEntity();
        entity.setName(data.getName());
        entity.setSurname(data.getSurname());
        entity.setEmail(data.getEmail());

        UserPreferencesEntity preferences = userPreferencesMapper.toEntity(data.getPreferences());
        entity.setPreferences(preferences);

       // List<ScenarioEntity> scenarios = data.getScenarios().stream().map(this.scenarioMapper::toEntity).collect(Collectors.toList());
        //entity.setScenarios(scenarios);


        return entity;
    }

    public UserTO toTransferObject(UserEntity data){
        UserTO transferObject = new UserTO();

        transferObject.setId(data.getId());
        transferObject.setName(data.getName());
        transferObject.setSurname(data.getSurname());
        transferObject.setEmail(data.getEmail());

        UserPreferencesTO preferences = userPreferencesMapper.toTransferObject(data.getPreferences());
        transferObject.setPreferences(preferences);

       // List<ScenarioTO> scenarios = data.getScenarios().stream().map(this.scenarioMapper::toTransferObject).collect(Collectors.toList());
       // transferObject.setScenarios(scenarios);

        return transferObject;
    }
}
