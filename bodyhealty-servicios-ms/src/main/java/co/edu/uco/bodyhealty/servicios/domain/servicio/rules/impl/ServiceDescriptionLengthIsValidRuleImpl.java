package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceDescriptionLengthIsNotValidException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDescriptionLengthIsValidRule;

@Service
public class ServiceDescriptionLengthIsValidRuleImpl implements ServiceDescriptionLengthIsValidRule {
    
    
    @Override
    public void validate(String data) {
        if (data.length() > 500) {
            throw ServiceDescriptionLengthIsNotValidException.create();
        }
    }
}