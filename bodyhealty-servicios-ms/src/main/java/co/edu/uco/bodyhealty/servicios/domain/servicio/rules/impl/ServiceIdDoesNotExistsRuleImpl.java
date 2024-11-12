package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.repository.ServicioRepository;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceIdDoesExistsException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdDoesNotExistsRule;

@Service
public class ServiceIdDoesNotExistsRuleImpl implements ServiceIdDoesNotExistsRule{

	private final ServicioRepository servicioRepository;

    public ServiceIdDoesNotExistsRuleImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public void validate(ServicioDomain data) {
        if (servicioRepository.existsById(data.getId())) {
            throw ServiceIdDoesExistsException.create(data.getId());
        }
    }

}
