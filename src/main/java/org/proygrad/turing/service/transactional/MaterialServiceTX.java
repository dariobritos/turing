package org.proygrad.turing.service.transactional;

import org.apache.log4j.Logger;
import org.proygrad.turing.api.material.MaterialTO;
import org.proygrad.turing.persistence.dao.material.MaterialDAO;
import org.proygrad.turing.persistence.entities.material.MaterialEntity;
import org.proygrad.turing.service.transactional.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MaterialServiceTX {

    private static final Logger LOGGER = Logger.getLogger(MaterialServiceTX.class);

    @Autowired
    private MaterialDAO materialDAO;

    @Autowired
    private MaterialMapper materialMapper;

    public List<MaterialTO> getMaterials(String userId, List<String> properties) {
        LOGGER.info("Reading materials for user: " + userId);
        return materialDAO.readByUserIdAndProperties(userId, properties).stream().map(this.materialMapper::toTransferObject).collect(Collectors.toList());
    }

    public String addMaterial(MaterialTO materialTO) {
        LOGGER.info("Saving material..");
        MaterialEntity entity = materialMapper.toEntity(materialTO);
        materialDAO.save(entity);
        LOGGER.info("Material saved: "+ entity.getId());
        return entity.getId();
    }



}
