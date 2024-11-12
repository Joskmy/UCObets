package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceNameLengthIsNotValidException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameLengthIsValidRule;

@Service
public class ServiceNameLengthIsValidRuleImpl implements ServiceNameLengthIsValidRule {

	@Override
    public void validate(String data) {
        if (data.length() > 50) {
            throw ServiceNameLengthIsNotValidException.create();
        }
    }

}
