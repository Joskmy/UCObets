package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.GetServiceIdRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdDoesExistsRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdIsNotNullRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdTypeIsValidRule;

@Service

public class GetServiceIdRulesValidatorImpl implements GetServiceIdRulesValidator {

	private ServiceIdDoesExistsRule serviceIdDoesExistsRule;
	private ServiceIdTypeIsValidRule serviceIdTypeIsValidRule;
	private ServiceIdIsNotNullRule serviceIdIsNotNullRule;
	
	
	public GetServiceIdRulesValidatorImpl(final ServiceIdDoesExistsRule serviceIdDoesExistsRule, final ServiceIdTypeIsValidRule serviceIdTypeIsValidRule,
			final ServiceIdIsNotNullRule serviceIdIsNotNullRule) {
		this.serviceIdDoesExistsRule = serviceIdDoesExistsRule;
		this.serviceIdTypeIsValidRule = serviceIdTypeIsValidRule;
		this.serviceIdIsNotNullRule = serviceIdIsNotNullRule;
	}

	@Override
	public void validate(final ServicioDomain data) {
		serviceIdIsNotNullRule.validate(data.getId());
		serviceIdTypeIsValidRule.validate(data.getId());
		serviceIdDoesExistsRule.validate(data);
		
	}
	
}