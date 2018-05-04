package org.proygrad.turing.service.transactional;

import org.apache.log4j.Logger;
import org.proygrad.turing.persistence.dao.scenario.RequestCalculationDAO;
import org.proygrad.turing.persistence.entities.request.RequestCalculationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RequestCalculationTX {

    private static final Logger LOGGER = Logger.getLogger(RequestCalculationTX.class);

    private static final String LIMIT_CALCULATION = "limit.query.request.calculation";

    @Autowired
    private Environment env;

    @Autowired
    private RequestCalculationDAO requestCalculationDAO;

    public String addRequestCalculation(String scenarioId) {

        LOGGER.info("Saving request calculation...");
        RequestCalculationEntity newRequest = new RequestCalculationEntity();
        newRequest.setId(scenarioId);
        newRequest.setRequestId(null);
        newRequest.setCreateDate(new Date());
        newRequest.setRequest(false);
        newRequest.setComplete(false);

        requestCalculationDAO.save(newRequest);
        LOGGER.info("Request calculation saved: " + newRequest.getId());
        return newRequest.getId();
    }

    public List<RequestCalculationEntity> getPendingRequest() {
        List<RequestCalculationEntity> pendingRequest = requestCalculationDAO.getPendingRequest(Integer.parseInt(env.getRequiredProperty(LIMIT_CALCULATION)));

        return pendingRequest;
    }

    public void markRequested(RequestCalculationEntity pendingRequest) {
        this.setCompleteTask(pendingRequest.getId(), true,false);
    }

    public void setRequestId(String entityId, String requestId) {
        RequestCalculationEntity toSave = requestCalculationDAO.load(entityId);
        toSave.setRequestId(requestId);

    }

    public void setCompleteTask(String entityId, boolean isRequest, boolean isComplete) {
        RequestCalculationEntity toSave = requestCalculationDAO.load(entityId);
        toSave.setRequest(isRequest);
        toSave.setComplete(isComplete);
    }

}
