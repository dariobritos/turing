package org.proygrad.turing.service.nontransactional;

import org.proygrad.turing.api.CalculationTO;
import org.proygrad.turing.service.transactional.CalculationServiceTX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationService {

    @Autowired
    CalculationServiceTX calculationServiceTX;


    public void addCalculation(CalculationTO calculationTO) {
        calculationServiceTX.addCalculation(calculationTO);
    }

    public List<CalculationTO> getCalculations() {
        return calculationServiceTX.getCalculations();
    }
}
