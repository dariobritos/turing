package org.proygrad.turing.service.transactional.mapper;

import org.proygrad.turing.api.material.ParameterDistributionTO;
import org.proygrad.turing.api.material.PropertyDistributionTO;
import org.proygrad.turing.persistence.entities.material.ParameterDistributionEntity;
import org.proygrad.turing.persistence.entities.material.PropertyDistributionEntity;
import org.springframework.stereotype.Service;

@Service
public class ParameterDistributionMapper {

    public ParameterDistributionEntity toEntity(ParameterDistributionTO data){
        ParameterDistributionEntity entity = new ParameterDistributionEntity();
        entity.setCode(data.getCode());
        entity.setValue(data.getValue());

        return entity;
    }

    public ParameterDistributionTO toTransferObject(ParameterDistributionEntity data){
        ParameterDistributionTO transferObject = new ParameterDistributionTO();

        transferObject.setId(data.getId());
        transferObject.setCode(data.getCode());
        transferObject.setValue(data.getValue());

        return transferObject;
    }
}
