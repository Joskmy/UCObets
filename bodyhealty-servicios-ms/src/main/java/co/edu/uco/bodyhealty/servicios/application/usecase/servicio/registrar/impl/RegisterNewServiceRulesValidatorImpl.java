package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.RegisterNewServiceDescriptionRulesValidator;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.RegisterNewServiceDurationRulesValidator;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.RegisterNewServiceNameRulesValidator;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.RegisterNewServiceRulesValidator;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.RegisterServiceIdRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Service
public class RegisterNewServiceRulesValidatorImpl implements RegisterNewServiceRulesValidator {

	private RegisterServiceIdRulesValidator serviceIdRulesValidator;
	private RegisterNewServiceNameRulesValidator serviceNameRulesValidator;
	private RegisterNewServiceDurationRulesValidator serviceDurationRulesValidator;
	private RegisterNewServiceDescriptionRulesValidator serviceDescriptionRulesValidator;
	
	
	
	public RegisterNewServiceRulesValidatorImpl(final RegisterServiceIdRulesValidator serviceIdRulesValidator,
			final RegisterNewServiceNameRulesValidator serviceNameRulesValidator,
			final RegisterNewServiceDurationRulesValidator serviceDurationRulesValidator,
			final RegisterNewServiceDescriptionRulesValidator serviceDescriptionRulesValidator) {
		this.serviceIdRulesValidator = serviceIdRulesValidator;
		this.serviceNameRulesValidator = serviceNameRulesValidator;
		this.serviceDurationRulesValidator = serviceDurationRulesValidator;
		this.serviceDescriptionRulesValidator = serviceDescriptionRulesValidator;
	}



	@Override
	public void validate(ServicioDomain data) {
		serviceIdRulesValidator.validate(data);
		//serviceNameRulesValidator.validate(data);
		serviceDurationRulesValidator.validate(data);
		serviceDescriptionRulesValidator.validate(data);

	}

	

}
