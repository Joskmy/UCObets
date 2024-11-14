package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.eliminar;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.RulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;


@Service
public interface DeleteServiceRulesValidator extends RulesValidator<ServicioDomain> {

}
