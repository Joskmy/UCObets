package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.RegisterNewServiceDurationRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDurationIsMultipleOfMinuteRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDurationIsNotNullRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDurationIsValidMinRule;

@Service

public class RegisterNewServiceDurationRulesValidatorImpl implements RegisterNewServiceDurationRulesValidator{
	
	private ServiceDurationIsMultipleOfMinuteRule serviceDurationIsMultipleOfMinuteRule;
	private ServiceDurationIsNotNullRule serviceDurationIsNotNullRule;
	private ServiceDurationIsValidMinRule serviceDurationIsValidMinRule;


	
	public RegisterNewServiceDurationRulesValidatorImpl(
			final ServiceDurationIsMultipleOfMinuteRule serviceDurationIsMultipleOfMinuteRule,
			final ServiceDurationIsNotNullRule serviceDurationIsNotNullRule,
			final ServiceDurationIsValidMinRule serviceDurationIsValidMinRule) {
		this.serviceDurationIsMultipleOfMinuteRule = serviceDurationIsMultipleOfMinuteRule;
		this.serviceDurationIsNotNullRule = serviceDurationIsNotNullRule;
		this.serviceDurationIsValidMinRule = serviceDurationIsValidMinRule;
	}

	@Override
	public void validate(ServicioDomain data) {
		serviceDurationIsNotNullRule.validate(data);
		serviceDurationIsValidMinRule.validate(data);
		serviceDurationIsMultipleOfMinuteRule.validate(data);		
	}

}
