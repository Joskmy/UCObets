package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.GetServiceNameRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameIsNotEmptyRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameIsNotNullRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameIsValidFormatRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameLengthIsValidRule;

@Service

public class GetServiceNameRulesValidatorImpl implements GetServiceNameRulesValidator {

	private ServiceNameIsNotNullRule serviceNameIsNotNullRule;
	private ServiceNameLengthIsValidRule serviceNameLengthIsValidRule;
	private ServiceNameIsValidFormatRule serviceNameIsValidFormatRule;
	private ServiceNameIsNotEmptyRule serviceNameIsNotEmptyRule;

	public GetServiceNameRulesValidatorImpl(final ServiceNameIsNotNullRule serviceNameIsNotNullRule,
			final ServiceNameLengthIsValidRule serviceNameLengthIsValidRule,
			final ServiceNameIsValidFormatRule serviceNameIsValidFormatRule,
			final ServiceNameIsNotEmptyRule serviceNameIsNotEmptyRule) {
		this.serviceNameIsNotNullRule = serviceNameIsNotNullRule;
		this.serviceNameLengthIsValidRule = serviceNameLengthIsValidRule;
		this.serviceNameIsValidFormatRule = serviceNameIsValidFormatRule;
		this.serviceNameIsNotEmptyRule = serviceNameIsNotEmptyRule;
	}

	@Override
	public void validate(ServicioDomain data) {
		serviceNameIsNotNullRule.validate(data.getNombreServicio());
		serviceNameIsNotEmptyRule.validate(data.getNombreServicio());
		serviceNameLengthIsValidRule.validate(data.getNombreServicio());
		serviceNameIsValidFormatRule.validate(data.getNombreServicio());

	}

}
