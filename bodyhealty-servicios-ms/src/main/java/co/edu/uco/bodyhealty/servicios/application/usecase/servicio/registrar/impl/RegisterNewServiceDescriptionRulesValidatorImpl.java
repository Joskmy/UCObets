package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.RegisterNewServiceDescriptionRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDescriptionIsNotEmptyRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDescriptionIsNotNullRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDescriptionLengthIsValidRule;

@Service

public class RegisterNewServiceDescriptionRulesValidatorImpl implements RegisterNewServiceDescriptionRulesValidator {
	
	private ServiceDescriptionLengthIsValidRule serviceDescriptionLengthIsValidRule;
	private ServiceDescriptionIsNotNullRule serviceDescriptionIsNotNullRule;
	private ServiceDescriptionIsNotEmptyRule serviceDescriptionIsNotEmptyRule;

	
	


	public RegisterNewServiceDescriptionRulesValidatorImpl(final ServiceDescriptionLengthIsValidRule serviceDescriptionLengthIsValidRule,
			final ServiceDescriptionIsNotNullRule serviceDescriptionIsNotNullRule,
			final ServiceDescriptionIsNotEmptyRule serviceDescriptionIsNotEmptyRule) {
		this.serviceDescriptionLengthIsValidRule = serviceDescriptionLengthIsValidRule;
		this.serviceDescriptionIsNotNullRule = serviceDescriptionIsNotNullRule;
		this.serviceDescriptionIsNotEmptyRule = serviceDescriptionIsNotEmptyRule;
	}





	@Override
	public void validate(ServicioDomain data) {
		serviceDescriptionIsNotNullRule.validate(data.getDescripcion());	
		serviceDescriptionIsNotEmptyRule.validate(data.getDescripcion());	
		serviceDescriptionLengthIsValidRule.validate(data.getDescripcion());	
	}

}
