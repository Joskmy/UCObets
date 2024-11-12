package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.actualizar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.actualizar.UpdateServiceIdRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdDoesExistsRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdIsNotNullRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdTypeIsValidRule;

@Service

public class UpdateServiceIdRulesValidatorImpl implements UpdateServiceIdRulesValidator {

	private ServiceIdDoesExistsRule serviceIdDoesExistsRule;
	private ServiceIdTypeIsValidRule serviceIdTypeIsValidRule;
	private ServiceIdIsNotNullRule serviceIdIsNotNullRule;
	
	
	public UpdateServiceIdRulesValidatorImpl(final ServiceIdDoesExistsRule serviceIdDoesExistsRule, final ServiceIdTypeIsValidRule serviceIdTypeIsValidRule,
			final ServiceIdIsNotNullRule serviceIdIsNotNullRule) {
		this.serviceIdDoesExistsRule = serviceIdDoesExistsRule;
		this.serviceIdTypeIsValidRule = serviceIdTypeIsValidRule;
		this.serviceIdIsNotNullRule = serviceIdIsNotNullRule;
	}

	@Override
	public void validate(final ServicioDomain data) {
		System.out.println("Entroo");
		serviceIdIsNotNullRule.validate(data.getId());
		serviceIdTypeIsValidRule.validate(data.getId());
		serviceIdDoesExistsRule.validate(data);
		System.out.println("SALIO");

		
	}
	
}