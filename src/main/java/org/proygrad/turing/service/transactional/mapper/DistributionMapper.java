package org.proygrad.turing.service.transactional.mapper;

import org.proygrad.turing.api.scenario.CommonItemTO;
import org.proygrad.turing.api.scenario.DistributionTO;
import org.proygrad.turing.persistence.entities.scenario.CommonItemEntity;
import org.proygrad.turing.persistence.entities.scenario.DistributionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistributionMapper {

    @Autowired
    private CommonItemMapper commonItemMapper;

    public DistributionEntity toEntity(DistributionTO data){
        DistributionEntity entity = new DistributionEntity();
        entity.setType(data.getType());

        List<CommonItemEntity> parameters = data.getParameters().stream().map(this.commonItemMapper::toEntity).collect(Collectors.toList());
        entity.setParameters(parameters);

        return entity;
    }

    public DistributionTO toTransferObject(DistributionEntity data){
        DistributionTO transferObject = new DistributionTO();
        transferObject.setId(data.getId());
        transferObject.setType(data.getType());

        List<CommonItemTO> parameters = data.getParameters().stream().map(this.commonItemMapper::toTransferObject).collect(Collectors.toList());
        transferObject.setParameters(parameters);

        return transferObject;
    }

}
