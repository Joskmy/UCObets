package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceDescriptionIsEmptyException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDescriptionIsNotEmptyRule;

@Service
public class ServiceDescriptionIsNotEmptyRuleImpl implements ServiceDescriptionIsNotEmptyRule{

	@Override
    public void validate(String data) {
        if (TextHelper.isEmpty(data)) {
            throw ServiceDescriptionIsEmptyException.create();
        }
    }

}
