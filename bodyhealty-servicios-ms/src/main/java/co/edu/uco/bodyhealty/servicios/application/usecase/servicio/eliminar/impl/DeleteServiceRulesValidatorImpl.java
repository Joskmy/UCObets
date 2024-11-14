package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.eliminar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.eliminar.DeleteServiceRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdDoesExistsRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdIsNotNullRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdTypeIsValidRule;

@Service
public class DeleteServiceRulesValidatorImpl implements DeleteServiceRulesValidator {

	private ServiceIdIsNotNullRule serviceIdIsNotNullRule;
	private ServiceIdTypeIsValidRule serviceIdTypeIsValidRule;
	private ServiceIdDoesExistsRule serviceIdDoesExistsRule;

	public DeleteServiceRulesValidatorImpl(final ServiceIdIsNotNullRule serviceIdIsNotNullRule,
			final ServiceIdTypeIsValidRule serviceIdTypeIsValidRule,
			final ServiceIdDoesExistsRule serviceIdDoesExistsRule) {
		this.serviceIdIsNotNullRule = serviceIdIsNotNullRule;
		this.serviceIdTypeIsValidRule = serviceIdTypeIsValidRule;
		this.serviceIdDoesExistsRule = serviceIdDoesExistsRule;
	}

	@Override
	public void validate(ServicioDomain domain) {
		serviceIdIsNotNullRule.validate(domain.getId());
		serviceIdTypeIsValidRule.validate(domain.getId());
		serviceIdDoesExistsRule.validate(domain);
	}

}
