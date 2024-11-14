package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.actualizar.UpdateServiceDescriptionRulesValidator;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.actualizar.UpdateServiceDurationRulesValidator;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.actualizar.UpdateServiceIdRulesValidator;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.actualizar.UpdateServiceNameRulesValidator;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.GetServiceRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Service
public class GetServiceRulesValidatorImpl implements GetServiceRulesValidator {

	private UpdateServiceIdRulesValidator serviceIdRulesValidator;
	private UpdateServiceNameRulesValidator serviceNameRulesValidator;
	private UpdateServiceDurationRulesValidator serviceDurationRulesValidator;
	private UpdateServiceDescriptionRulesValidator serviceDescriptionRulesValidator;

	public GetServiceRulesValidatorImpl(final UpdateServiceIdRulesValidator serviceIdRulesValidator,
			final UpdateServiceNameRulesValidator serviceNameRulesValidator,
			final UpdateServiceDurationRulesValidator serviceDurationRulesValidator,
			final UpdateServiceDescriptionRulesValidator serviceDescriptionRulesValidator) {
		this.serviceIdRulesValidator = serviceIdRulesValidator;
		this.serviceNameRulesValidator = serviceNameRulesValidator;
		this.serviceDurationRulesValidator = serviceDurationRulesValidator;
		this.serviceDescriptionRulesValidator = serviceDescriptionRulesValidator;
	}

	@Override
	public void validate(ServicioDomain data) {
		serviceNameRulesValidator.validate(data);
		System.out.println("2");
		serviceDurationRulesValidator.validate(data);
		System.out.println("3");
		serviceDescriptionRulesValidator.validate(data);
		System.out.println("SALIOOOO");

	}

}
