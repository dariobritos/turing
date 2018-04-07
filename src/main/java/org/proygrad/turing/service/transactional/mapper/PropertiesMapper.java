package org.proygrad.turing.service.transactional.mapper;

import com.netflix.discovery.converters.Auto;
import org.proygrad.turing.api.material.PropertyDistributionTO;
import org.proygrad.turing.api.material.PropertyTO;
import org.proygrad.turing.persistence.entities.material.PropertyDistributionEntity;
import org.proygrad.turing.persistence.entities.material.PropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertiesMapper {

    @Autowired
    private PropertyDistributionMapper propertyDistributionMapper;

    public PropertyEntity toEntity(PropertyTO data){
        PropertyEntity entity = new PropertyEntity();
        entity.setCode(data.getCode());
        entity.setValue(data.getValue());
        entity.setUnit(data.getUnit());
        entity.setType(data.getType());
        entity.setMagnitude(data.getMagnitude());

        PropertyDistributionEntity propertyDistributionEntity = propertyDistributionMapper.toEntity(data.getDistribution());
        entity.setDistribution(propertyDistributionEntity);

        return entity;
    }

    public PropertyTO toTransferObject(PropertyEntity data){
        PropertyTO transferObject = new PropertyTO();

        transferObject.setId(data.getId());
        transferObject.setCode(data.getCode());
        transferObject.setValue(data.getValue());
        transferObject.setUnit(data.getUnit());
        transferObject.setType(data.getType());
        transferObject.setMagnitude(data.getMagnitude());


        PropertyDistributionTO propertyDistributionTO = propertyDistributionMapper.toTransferObject(data.getDistribution());
        transferObject.setDistribution(propertyDistributionTO);

        return transferObject;
    }
}
