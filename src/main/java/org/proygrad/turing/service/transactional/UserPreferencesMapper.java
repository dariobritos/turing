package org.proygrad.turing.service.transactional;

import org.proygrad.turing.api.user.UserPreferencesTO;
import org.proygrad.turing.persistence.entities.UserPreferencesEntity;
import org.springframework.stereotype.Service;

@Service
public class UserPreferencesMapper {

    public UserPreferencesEntity toEntity(UserPreferencesTO data){
        UserPreferencesEntity entity = new UserPreferencesEntity();
        entity.setLanguage(data.getLanguage());
        entity.setUnitSystem(data.getUnitSystem());
        entity.setFastScenario(data.getFastScenario());

        return entity;
    }

    public UserPreferencesTO toTransferObject(UserPreferencesEntity data){
        UserPreferencesTO transferObject = new UserPreferencesTO();

        transferObject.setId(data.getId());
        transferObject.setLanguage(data.getLanguage());
        transferObject.setUnitSystem(data.getUnitSystem());
        transferObject.setFastScenario(data.getFastScenario());

        return transferObject;
    }
}

