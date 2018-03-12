package org.proygrad.turing.service.transactional.mapper;

import org.proygrad.turing.api.scenario.DistributionTO;
import org.proygrad.turing.api.scenario.ParameterTO;
import org.proygrad.turing.persistence.entities.scenario.DistributionEntity;
import org.proygrad.turing.persistence.entities.scenario.ParameterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterMapper {

    private static final String DETERMINISTIC = "DETERMINISTIC";

    @Autowired
    private DistributionMapper distributionMapper;

    public ParameterEntity toEntity(ParameterTO data){
        ParameterEntity entity = new ParameterEntity();
        entity.setCode(data.getCode());
        entity.setMagnitude(data.getMagnitude());
        entity.setType(data.getType());
        entity.setUnit(data.getUnit());
        entity.setValue(data.getValue());

        if(!DETERMINISTIC.equals(data.getType())) {
            DistributionEntity distribution = distributionMapper.toEntity(data.getDistribution());
            entity.setDistribution(distribution);
        }

        return entity;
    }

    public ParameterTO toTransferObject(ParameterEntity data){
        ParameterTO transferObject = new ParameterTO();
        transferObject.setId(data.getId());
        transferObject.setCode(data.getCode());
        transferObject.setMagnitude(data.getMagnitude());
        transferObject.setType(data.getType());
        transferObject.setUnit(data.getUnit());
        transferObject.setValue(data.getValue());

        if(!DETERMINISTIC.equals(data.getType())) {
            DistributionTO distribution = distributionMapper.toTransferObject(data.getDistribution());
            transferObject.setDistribution(distribution);
        }

        return transferObject;
    }

}
