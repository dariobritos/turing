package org.proygrad.turing.service.transactional;


import org.proygrad.turing.api.ScenarioTO;
import org.proygrad.turing.persistence.entities.ScenarioEntity;
import org.springframework.stereotype.Service;

@Service
public class ScenarioMapper {

    public ScenarioEntity toEntity(ScenarioTO data){
        ScenarioEntity entity = new ScenarioEntity();
        entity.setType(data.getType());
        entity.setUnit(data.getUnit());

        return entity;
    }


    public ScenarioTO toTransferObject(ScenarioEntity data){
        ScenarioTO transferObject = new ScenarioTO();

        transferObject.setId(data.getId());
        transferObject.setType(data.getType());
        transferObject.setUnit(data.getUnit());

        return transferObject;
    }


}

