package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Service
public interface GetService {
    ServicioDomain executeById(ServicioDomain domain);
    List<ServicioDomain> executeByFilter(ServicioDomain domain);
}