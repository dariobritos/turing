package org.proygrad.turing.service.transactional;

import org.apache.log4j.Logger;
import org.proygrad.turing.api.material.MaterialTO;
import org.proygrad.turing.api.material.PropertyTO;
import org.proygrad.turing.persistence.dao.material.MaterialDAO;
import org.proygrad.turing.persistence.entities.material.MaterialEntity;
import org.proygrad.turing.persistence.entities.material.PropertyEntity;
import org.proygrad.turing.service.transactional.mapper.MaterialMapper;
import org.proygrad.turing.service.transactional.mapper.PropertiesMapper;
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

    @Autowired
    private PropertiesMapper propertiesMapper;

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


    public void deleteMaterial(String id) {
        LOGGER.info("Deleting material..");
        materialDAO.delete(id);
        LOGGER.info("Material deleted: "+ id);
    }

    public MaterialTO getMaterial(String id) {
        LOGGER.info("Reading material for id: " + id);
        return materialMapper.toTransferObject(materialDAO.load(id));

    }

    public String updateMaterial(String id, MaterialTO materialTO) {
        MaterialEntity entity = materialDAO.load(id);

        if(entity != null){
            entity.setName(materialTO.getName());
            entity.setUserId(materialTO.getUserId());

            entity.getProperties().clear();
            entity.getProperties().addAll(materialTO.getProperties().stream().map(this.propertiesMapper::toEntity).collect(Collectors.toList()));

            return entity.getId();
        }

        return null;
    }
}
