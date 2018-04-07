package org.proygrad.turing.rest.controller;

import org.apache.log4j.Logger;
import org.proygrad.turing.api.material.MaterialTO;
import org.proygrad.turing.service.nontransactional.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialController {

    private static final Logger LOGGER = Logger.getLogger(MaterialController.class);

    @Autowired
    private MaterialService materialService; // el service q me resuelva

    @RequestMapping(value = "/material", method = RequestMethod.GET)
    public List<MaterialTO> getMaterials(@RequestParam(value = "user_id", required = false) String userId,
                                         @RequestParam(value = "properties", required = false) List<String> properties) {
        LOGGER.info("GET Materials request received...");
        return materialService.getMaterials(userId, properties);
    }

}

