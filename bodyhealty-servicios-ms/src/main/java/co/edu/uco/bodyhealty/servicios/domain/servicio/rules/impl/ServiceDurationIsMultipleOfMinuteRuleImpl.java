package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceDurationIsNotMultipleOfMinuteException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDurationIsMultipleOfMinuteRule;

@Service
public class ServiceDurationIsMultipleOfMinuteRuleImpl implements ServiceDurationIsMultipleOfMinuteRule {

	@Override
	public void validate(ServicioDomain data) {
		if (data.getDuracionEstimada() % 15 != 0) {
			throw ServiceDurationIsNotMultipleOfMinuteException.create();
		}
		
	}

}
