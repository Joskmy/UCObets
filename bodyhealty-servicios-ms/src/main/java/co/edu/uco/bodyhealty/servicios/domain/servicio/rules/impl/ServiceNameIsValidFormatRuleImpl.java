package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceNameFormatIsNotValidException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameIsValidFormatRule;

@Service
public class ServiceNameIsValidFormatRuleImpl implements ServiceNameIsValidFormatRule {

	private static final Pattern VALID_NAME_PATTERN = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");

    @Override
    public void validate(String data) {
        if (!VALID_NAME_PATTERN.matcher(data).matches()) {
            throw ServiceNameFormatIsNotValidException.create();
        }
    }

}
