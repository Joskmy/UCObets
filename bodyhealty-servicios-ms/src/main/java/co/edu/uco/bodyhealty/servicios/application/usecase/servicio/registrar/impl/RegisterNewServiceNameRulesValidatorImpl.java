package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.RegisterNewServiceNameRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameIsNotEmptyRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameIsNotNullRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameIsUniqueRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameIsValidFormatRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameLengthIsValidRule;


@Service

public class RegisterNewServiceNameRulesValidatorImpl implements RegisterNewServiceNameRulesValidator {
	
	private ServiceNameIsNotNullRule serviceNameIsNotNullRule;
	private ServiceNameLengthIsValidRule serviceNameLengthIsValidRule;
	private ServiceNameIsValidFormatRule serviceNameIsValidFormatRule;
	private ServiceNameIsUniqueRule serviceNameIsUniqueRule;
	private ServiceNameIsNotEmptyRule serviceNameIsNotEmptyRule;
	
	
	
	public RegisterNewServiceNameRulesValidatorImpl(final ServiceNameIsNotNullRule serviceNameIsNotNullRule,
			final ServiceNameLengthIsValidRule serviceNameLengthIsValidRule,
			final ServiceNameIsValidFormatRule serviceNameIsValidFormatRule,
			final ServiceNameIsUniqueRule serviceNameIsUniqueRule,
			final ServiceNameIsNotEmptyRule serviceNameIsNotEmptyRule) {
		this.serviceNameIsNotNullRule = serviceNameIsNotNullRule;
		this.serviceNameLengthIsValidRule = serviceNameLengthIsValidRule;
		this.serviceNameIsValidFormatRule = serviceNameIsValidFormatRule;
		this.serviceNameIsUniqueRule = serviceNameIsUniqueRule;
		this.serviceNameIsNotEmptyRule = serviceNameIsNotEmptyRule;
	}

	@Override
	public void validate(ServicioDomain data) {
		serviceNameIsNotNullRule.validate(data.getNombreServicio());
		serviceNameIsNotEmptyRule.validate(data.getNombreServicio());
		serviceNameLengthIsValidRule.validate(data.getNombreServicio());
		serviceNameIsValidFormatRule.validate(data.getNombreServicio());
		serviceNameIsUniqueRule.validate(data);

		
	}

}
