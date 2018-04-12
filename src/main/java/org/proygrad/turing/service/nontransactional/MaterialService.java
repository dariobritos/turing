package org.proygrad.turing.service.nontransactional;

import org.apache.commons.lang.StringUtils;
import org.proygrad.turing.api.material.MaterialTO;
import org.proygrad.turing.service.transactional.MaterialServiceTX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialService {

    @Autowired
    private MaterialServiceTX materialServiceTX;

    public List<MaterialTO> getMaterials(String userId, List<String> properties) {
        List<MaterialTO> materials = materialServiceTX.getMaterials(userId);

        if(properties!= null && !properties.isEmpty()){
            materials = materials.stream().filter(m ->
                    (m.getProperties() != null  &&
                            m.getProperties().stream().anyMatch(p -> properties.contains(p.getCode()))
            )).collect(Collectors.toList());
        }
        return materials;
    }

    public String addMaterial(MaterialTO materialTO) {
        String materialId = materialServiceTX.addMaterial(materialTO);

        return materialId;
    }

    public void deleteMaterial(String id) {
        materialServiceTX.deleteMaterial(id);
    }

    public MaterialTO getMaterial(String id) {
        return materialServiceTX.getMaterial(id);
    }

    public String updateMaterial(String id, MaterialTO materialTO) {
        return materialServiceTX.updateMaterial(id, materialTO);
    }

}
