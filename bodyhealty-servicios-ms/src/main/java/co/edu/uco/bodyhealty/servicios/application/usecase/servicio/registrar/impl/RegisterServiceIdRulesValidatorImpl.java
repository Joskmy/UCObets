package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.RegisterServiceIdRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdDoesNotExistsRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdIsNotNullRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdTypeIsValidRule;

@Service

public class RegisterServiceIdRulesValidatorImpl implements RegisterServiceIdRulesValidator {

	private ServiceIdDoesNotExistsRule serviceIdDoesNotExistsRule;
	private ServiceIdTypeIsValidRule serviceIdTypeIsValidRule;
	private ServiceIdIsNotNullRule serviceIdIsNotNullRule;
	
	
	public RegisterServiceIdRulesValidatorImpl(final ServiceIdDoesNotExistsRule serviceIdDoesNotExistsRule, final ServiceIdTypeIsValidRule serviceIdTypeIsValidRule,
			final ServiceIdIsNotNullRule serviceIdIsNotNullRule) {
		this.serviceIdDoesNotExistsRule = serviceIdDoesNotExistsRule;
		this.serviceIdTypeIsValidRule = serviceIdTypeIsValidRule;
		this.serviceIdIsNotNullRule = serviceIdIsNotNullRule;
	}

	@Override
	public void validate(final ServicioDomain data) {
		serviceIdIsNotNullRule.validate(data.getId());
		serviceIdTypeIsValidRule.validate(data.getId());
		serviceIdDoesNotExistsRule.validate(data);
		
	}
	
}