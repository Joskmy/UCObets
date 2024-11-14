package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.RulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Service
public interface GetServiceNameRulesValidator extends RulesValidator<ServicioDomain> {

}
