package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.NumericHelper;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceDurationIsNotNullException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDurationIsNotNullRule;

@Service
public class ServiceDurationIsNotNullRuleImpl implements ServiceDurationIsNotNullRule {

	@Override
    public void validate(ServicioDomain data) {
        if (NumericHelper.isNull(data.getDuracionEstimada())) {
            throw ServiceDurationIsNotNullException.create();
        }
    }

}
