package org.proygrad.turing.service.transactional.mapper;

import org.proygrad.turing.api.material.ParameterDistributionTO;
import org.proygrad.turing.api.material.PropertyDistributionTO;
import org.proygrad.turing.api.material.PropertyTO;
import org.proygrad.turing.persistence.entities.material.ParameterDistributionEntity;
import org.proygrad.turing.persistence.entities.material.PropertyDistributionEntity;
import org.proygrad.turing.persistence.entities.material.PropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyDistributionMapper {

    @Autowired
    private ParameterDistributionMapper parameterDistributionMapper;

    public PropertyDistributionEntity toEntity(PropertyDistributionTO data){
        PropertyDistributionEntity entity = new PropertyDistributionEntity();
        entity.setType(data.getType());

        List<ParameterDistributionEntity> parameters = data.getParameters().stream().map(this.parameterDistributionMapper::toEntity).collect(Collectors.toList());
        entity.setParameters(parameters);

        return entity;
    }

    public PropertyDistributionTO toTransferObject(PropertyDistributionEntity data){
        PropertyDistributionTO transferObject = new PropertyDistributionTO();

        transferObject.setId(data.getId());
        transferObject.setType(data.getType());

        List<ParameterDistributionTO> parameters = data.getParameters().stream().map(this.parameterDistributionMapper::toTransferObject).collect(Collectors.toList());
        transferObject.setParameters(parameters);


        return transferObject;
    }
}
