package org.proygrad.turing.service.nontransactional;


import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.persistence.entities.request.RequestCalculationEntity;
import org.proygrad.turing.rest.client.EinsteinClient;
import org.proygrad.turing.service.transactional.RequestCalculationTX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestCalculationJob {

    @Autowired
    private EinsteinClient einsteinClient;

    @Autowired
    private RequestCalculationTX requestCalculationTX;

    @Scheduled(fixedDelay = 7200, initialDelay = 900)
    public void run(){

        List<RequestCalculationEntity> pendingRequests = requestCalculationTX.getPendingRequest();

        for(RequestCalculationEntity pendingRequest : pendingRequests) {

            ScenarioTO scenarioTO = new ScenarioTO();
            scenarioTO.setId(pendingRequest.getId());

            String requestCalculationId = einsteinClient.postCalculation(scenarioTO);

            requestCalculationTX.setRequestId(pendingRequest.getId(), requestCalculationId);

        }
    }

}
