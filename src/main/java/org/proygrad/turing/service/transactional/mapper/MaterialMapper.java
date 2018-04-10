package org.proygrad.turing.service.transactional.mapper;

import org.proygrad.turing.api.material.MaterialTO;
import org.proygrad.turing.api.material.PropertyTO;
import org.proygrad.turing.persistence.entities.material.MaterialEntity;
import org.proygrad.turing.persistence.entities.material.PropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialMapper {

    @Autowired
    private PropertiesMapper propertiesMapper;

    public MaterialEntity toEntity(MaterialTO data){
        MaterialEntity entity = new MaterialEntity();
        entity.setName(data.getName());

        List<PropertyEntity> properties = data.getProperties().stream().map(this.propertiesMapper::toEntity).collect(Collectors.toList());
        entity.setProperties(properties);

        entity.setUserId(data.getUserId());

        return entity;
    }

    public MaterialTO toTransferObject(MaterialEntity data){
        MaterialTO transferObject = new MaterialTO();

        transferObject.setId(data.getId());
        transferObject.setName(data.getName());

        List<PropertyTO> properties = data.getProperties().stream().map(this.propertiesMapper::toTransferObject).collect(Collectors.toList());
        transferObject.setProperties(properties);

        transferObject.setUserId(data.getUserId());

        return transferObject;
    }
}
