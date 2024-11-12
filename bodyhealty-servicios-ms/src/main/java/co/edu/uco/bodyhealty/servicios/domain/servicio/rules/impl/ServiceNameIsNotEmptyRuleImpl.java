package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceNameIsEmptyException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameIsNotEmptyRule;

@Service
public class ServiceNameIsNotEmptyRuleImpl implements ServiceNameIsNotEmptyRule{

	@Override
    public void validate(String data) {
        if (TextHelper.isEmpty(data)) {
            throw ServiceNameIsEmptyException.create();
        }
    }

}
