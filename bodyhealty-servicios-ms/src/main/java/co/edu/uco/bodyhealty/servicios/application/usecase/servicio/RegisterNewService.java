package co.edu.uco.bodyhealty.servicios.application.usecase.servicio;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.usecase.UseCaseWithoutReturn;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Service
public interface RegisterNewService extends UseCaseWithoutReturn<ServicioDomain> {

}