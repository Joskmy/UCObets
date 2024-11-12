package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.actualizar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.actualizar.UpdateServiceDurationRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDurationIsMultipleOfMinuteRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDurationIsNotNullRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDurationIsValidMinRule;

@Service

public class UpdateServiceDurationRulesValidatorImpl implements UpdateServiceDurationRulesValidator{
	
	private ServiceDurationIsMultipleOfMinuteRule serviceDurationIsMultipleOfMinuteRule;
	private ServiceDurationIsNotNullRule serviceDurationIsNotNullRule;
	private ServiceDurationIsValidMinRule serviceDurationIsValidMinRule;


	
	public UpdateServiceDurationRulesValidatorImpl(
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
