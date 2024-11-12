package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.UUIDHelper;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceIdTypeIsNotValidException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdTypeIsValidRule;

@Service
public class ServiceIdTypeIsValidRuleImpl implements ServiceIdTypeIsValidRule {

	@Override
	public void validate(UUID data) {
		if(! UUIDHelper.isValidUUID(data)) {
			throw ServiceIdTypeIsNotValidException.create(data);
		}
		
	}

}
