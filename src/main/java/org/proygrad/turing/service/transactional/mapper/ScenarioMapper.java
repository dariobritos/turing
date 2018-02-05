package org.proygrad.turing.service.transactional.mapper;


import org.proygrad.turing.api.scenario.CommonItemTO;
import org.proygrad.turing.api.scenario.ParameterTO;
import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.persistence.entities.scenario.CommonItemEntity;
import org.proygrad.turing.persistence.entities.scenario.ParameterEntity;
import org.proygrad.turing.persistence.entities.scenario.ScenarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScenarioMapper {


    @Autowired
    private ParameterMapper parameterMapper;

    @Autowired
    private CommonItemMapper commonItemMapper;

    public ScenarioEntity toEntity(ScenarioTO data){
        ScenarioEntity entity = new ScenarioEntity();
        entity.setType(data.getType());
        entity.setUnitSystem(data.getUnitSystem());

        List<ParameterEntity> parameters = data.getParameters().stream().map(this.parameterMapper::toEntity).collect(Collectors.toList());
        entity.setParameters(parameters);

        List<CommonItemEntity> configurations = data.getConfiguration().stream().map(this.commonItemMapper::toEntity).collect(Collectors.toList());
        entity.setConfiguration(configurations);

        entity.setComments(data.getComments());

        if(data.getOutput() != null) {
            List<CommonItemEntity> outputs = data.getOutput().stream().map(this.commonItemMapper::toEntity).collect(Collectors.toList());
            entity.setOutput(outputs);
        }

        return entity;
    }


    public ScenarioTO toTransferObject(ScenarioEntity data){
        ScenarioTO transferObject = new ScenarioTO();

        transferObject.setId(data.getId());
        transferObject.setType(data.getType());
        transferObject.setUnitSystem(data.getUnitSystem());

        List<ParameterTO> parameters = data.getParameters().stream().map(this.parameterMapper::toTransferObject).collect(Collectors.toList());
        transferObject.setParameters(parameters);

        List<CommonItemTO> configurations = data.getConfiguration().stream().map(this.commonItemMapper::toTransferObject).collect(Collectors.toList());
        transferObject.setConfiguration(configurations);

        transferObject.setComments(data.getComments());

        List<CommonItemTO> outputs = data.getOutput().stream().map(this.commonItemMapper::toTransferObject).collect(Collectors.toList());
        transferObject.setOutput(outputs);

        return transferObject;
    }


}

