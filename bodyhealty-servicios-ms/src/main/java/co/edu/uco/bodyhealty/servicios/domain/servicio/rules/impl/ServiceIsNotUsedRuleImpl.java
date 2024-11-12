package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.repository.ServicioRepository;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceIsUsedException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIsNotUsedRule;

@Service
public class ServiceIsNotUsedRuleImpl implements ServiceIsNotUsedRule{

	private final ServicioRepository servicioRepository;

    public ServiceIsNotUsedRuleImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public void validate(UUID data) {
        if (servicioRepository.existsById(data)) {
            throw ServiceIsUsedException.create(data);
        }
    }

}
