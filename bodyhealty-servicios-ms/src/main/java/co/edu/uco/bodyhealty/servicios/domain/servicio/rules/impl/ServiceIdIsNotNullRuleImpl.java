package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceIdIsNullException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdIsNotNullRule;

@Service
public class ServiceIdIsNotNullRuleImpl implements ServiceIdIsNotNullRule {

	@Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)) {
            throw ServiceIdIsNullException.create();
        }
    }

}
