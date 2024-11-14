package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.GetServiceDurationRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDurationIsMultipleOfMinuteRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDurationIsNotNullRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDurationIsValidMinRule;

@Service

public class GetServiceDurationRulesValidatorImpl implements GetServiceDurationRulesValidator{
	
	private ServiceDurationIsMultipleOfMinuteRule serviceDurationIsMultipleOfMinuteRule;
	private ServiceDurationIsNotNullRule serviceDurationIsNotNullRule;

	public GetServiceDurationRulesValidatorImpl(
			final ServiceDurationIsMultipleOfMinuteRule serviceDurationIsMultipleOfMinuteRule,
			final ServiceDurationIsNotNullRule serviceDurationIsNotNullRule,
			final ServiceDurationIsValidMinRule serviceDurationIsValidMinRule) {
		this.serviceDurationIsMultipleOfMinuteRule = serviceDurationIsMultipleOfMinuteRule;
		this.serviceDurationIsNotNullRule = serviceDurationIsNotNullRule;
	}

	@Override
	public void validate(ServicioDomain data) {
		serviceDurationIsNotNullRule.validate(data);
		serviceDurationIsMultipleOfMinuteRule.validate(data);		
	}

}
