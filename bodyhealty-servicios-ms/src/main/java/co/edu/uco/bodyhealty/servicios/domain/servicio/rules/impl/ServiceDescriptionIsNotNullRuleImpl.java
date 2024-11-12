package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceDescriptionIsNotNullException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDescriptionIsNotNullRule;

@Service
public class ServiceDescriptionIsNotNullRuleImpl implements ServiceDescriptionIsNotNullRule{

	@Override
    public void validate(String data) {
        if (TextHelper.isNull(data)) {
            throw ServiceDescriptionIsNotNullException.create();
        }
    }

}
