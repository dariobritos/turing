package org.proygrad.turing.service.transactional.mapper;

import org.proygrad.turing.api.scenario.CommonItemTO;
import org.proygrad.turing.persistence.entities.scenario.CommonItemEntity;
import org.springframework.stereotype.Service;

@Service
public class CommonItemMapper {

    public CommonItemEntity toEntity(CommonItemTO data){
        CommonItemEntity entity = new CommonItemEntity();
        entity.setCode(data.getCode());
        entity.setValue(data.getValue());

        return entity;
    }

    public CommonItemTO toTransferObject(CommonItemEntity data){
        CommonItemTO transferObject = new CommonItemTO();
        transferObject.setId(data.getId());
        transferObject.setCode(data.getCode());
        transferObject.setValue(data.getValue());

        return transferObject;
    }


}
