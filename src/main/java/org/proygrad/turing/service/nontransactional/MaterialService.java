package org.proygrad.turing.service.nontransactional;

import org.apache.commons.lang.StringUtils;
import org.proygrad.turing.api.material.MaterialTO;
import org.proygrad.turing.service.transactional.MaterialServiceTX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialServiceTX materialServiceTX;

    public List<MaterialTO> getMaterials(String userId, List<String> properties) {
        return materialServiceTX.getMaterials(userId, properties);
    }

    public String addMaterial(MaterialTO materialTO) {
        String materialId = materialServiceTX.addMaterial(materialTO);

        return materialId;
    }

    public void deleteMaterial(String id) {

    }

}
