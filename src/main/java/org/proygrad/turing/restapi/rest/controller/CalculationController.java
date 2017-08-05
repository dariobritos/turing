package org.proygrad.turing.restapi.rest.controller;

import org.proygrad.turing.restapi.rest.api.Calculation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {

    @RequestMapping(value = "/calculation", method = RequestMethod.GET)
    public Calculation calculation() {

        Calculation calculationFirst = new Calculation();
        calculationFirst.setId("1");
        calculationFirst.setName("ADD");
        calculationFirst.setType("Add value");
        calculationFirst.setResult("123");

        return calculationFirst;
    }

}
