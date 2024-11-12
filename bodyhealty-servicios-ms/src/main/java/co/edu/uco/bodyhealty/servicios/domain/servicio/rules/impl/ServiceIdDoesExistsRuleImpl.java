package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.repository.ServicioRepository;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceIdDoesNotExistsException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceIdDoesExistsRule;

@Service
public class ServiceIdDoesExistsRuleImpl implements ServiceIdDoesExistsRule{

	private final ServicioRepository servicioRepository;

    public ServiceIdDoesExistsRuleImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public void validate(ServicioDomain data) {
        System.out.println("Validando existencia del ID: " + data.getId());
        boolean exists = servicioRepository.existsById(data.getId());
        System.out.println("¿Existe el ID?: " + exists);
        
        if (!exists) {
            throw ServiceIdDoesNotExistsException.create(data.getId());
        }
    }

}
