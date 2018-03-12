package org.proygrad.turing.rest.client;


import org.proygrad.turing.api.scenario.ScenarioTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EinsteinClient {

    private static String DIR_EINSTEIN = "http://einstein";

    private static String POST_CALCULATION = DIR_EINSTEIN + "/calculation";

    @Autowired
    private RestTemplate restTemplate;


    public String postCalculation(ScenarioTO scenarioTO) {
        return restTemplate.postForEntity(POST_CALCULATION,scenarioTO, String.class).getBody();
    }


}
