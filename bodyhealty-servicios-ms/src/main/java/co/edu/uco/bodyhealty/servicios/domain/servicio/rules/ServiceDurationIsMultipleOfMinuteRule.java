package co.edu.uco.bodyhealty.servicios.domain.servicio.rules;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.domain.DomainRule;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;


@Service
public interface ServiceDurationIsMultipleOfMinuteRule extends DomainRule<ServicioDomain> {

}
