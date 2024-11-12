package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.NumericHelper;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceDurationIsNotValidMinException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceDurationIsValidMinRule;

@Service
public class ServiceDurationIsValidMinRuleImpl implements ServiceDurationIsValidMinRule {

	@Override
    public void validate(ServicioDomain data) {
        if (NumericHelper.isLess(data.getDuracionEstimada(), 15)) {
            throw ServiceDurationIsNotValidMinException.create();
        }
    }

}
