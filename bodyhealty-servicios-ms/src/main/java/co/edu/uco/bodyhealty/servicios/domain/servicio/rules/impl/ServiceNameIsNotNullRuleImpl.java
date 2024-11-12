package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceNameIsNullException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameIsNotNullRule;

@Service
public class ServiceNameIsNotNullRuleImpl implements ServiceNameIsNotNullRule{

	@Override
    public void validate(String data) {
        if (TextHelper.isNull(data)) {
            throw ServiceNameIsNullException.create();
        }
    }

}
