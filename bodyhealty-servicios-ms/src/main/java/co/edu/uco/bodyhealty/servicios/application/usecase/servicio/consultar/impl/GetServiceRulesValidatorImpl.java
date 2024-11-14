package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.GetServiceDurationRulesValidator;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.GetServiceNameRulesValidator;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.GetServiceRulesValidator;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.NumericHelper;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Service
public class GetServiceRulesValidatorImpl implements GetServiceRulesValidator {

	private GetServiceNameRulesValidator serviceNameRulesValidator;
	private GetServiceDurationRulesValidator serviceDurationRulesValidator;

	public GetServiceRulesValidatorImpl(final GetServiceNameRulesValidator serviceNameRulesValidator,
			final GetServiceDurationRulesValidator serviceDurationRulesValidator) {
		this.serviceNameRulesValidator = serviceNameRulesValidator;
		this.serviceDurationRulesValidator = serviceDurationRulesValidator;
	}

	@Override
    public void validate(ServicioDomain data) {
        if (!TextHelper.isEmpty(data.getNombreServicio())) {
            serviceNameRulesValidator.validate(data);
        }
        
        if (data.getDuracionEstimada() > NumericHelper.ZERO) {
            serviceDurationRulesValidator.validate(data);
        }
    }

}
