package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameIsUniqueRule;

@Service
public class ServiceNameIsUniqueRuleImpl implements  ServiceNameIsUniqueRule{

	@Override
	public void validate(ServicioDomain data) {
		// TODO Auto-generated method stub
		
	}

}
