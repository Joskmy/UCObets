package co.edu.uco.bodyhealty.servicios.domain.servicio.rules;


import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.domain.DomainRule;


@Service
public interface ServiceNameIsNotEmptyRule extends DomainRule<String> {

}
