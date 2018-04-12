package org.proygrad.turing.rest.controller;

import org.apache.log4j.Logger;
import org.proygrad.turing.api.material.MaterialTO;
import org.proygrad.turing.service.nontransactional.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaterialController {

    private static final Logger LOGGER = Logger.getLogger(MaterialController.class);

    @Autowired
    private MaterialService materialService; // el service q me resuelva

    @RequestMapping(value = "/material/{id}", method = RequestMethod.GET)
    public MaterialTO getMaterial(@PathVariable("id") String id) {
        LOGGER.info("GET Material request received: " + id);
        return materialService.getMaterial(id);
    }

    @RequestMapping(value = "/material", method = RequestMethod.GET)
    public List<MaterialTO> getMaterials(@RequestParam(value = "user_id", required = false) String userId,
                                         @RequestParam(value = "properties", required = false) List<String> properties) {
        LOGGER.info("GET Materials request received...");
        return materialService.getMaterials(userId, properties);
    }

    @RequestMapping(value = "/material", method = RequestMethod.POST)
    public String addMaterial(@RequestBody MaterialTO materialTO) {
        LOGGER.info("POST Material request received...");
        return materialService.addMaterial(materialTO);
    }

    @RequestMapping(value = "/material/{id}", method = RequestMethod.DELETE)
    public void deleteMaterial(@PathVariable("id") String id) {
        LOGGER.info("DELETE Material request received: " + id);
        materialService.deleteMaterial(id);
    }

    @RequestMapping(value = "/material/{id}", method = RequestMethod.PATCH)
    public String updateMaterial(@PathVariable("id") String id, @RequestBody MaterialTO materialTO) {
        LOGGER.info("PATCH Material request received: " + id);
        return materialService.updateMaterial(id, materialTO);
    }
}

