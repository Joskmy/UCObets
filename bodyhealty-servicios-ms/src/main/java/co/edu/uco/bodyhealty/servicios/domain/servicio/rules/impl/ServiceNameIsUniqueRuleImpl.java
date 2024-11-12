package co.edu.uco.bodyhealty.servicios.domain.servicio.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.mapper.servicio.ServicioEntityMapper;
import co.edu.uco.bodyhealty.servicios.application.secondaryports.repository.ServicioRepository;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;
import co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions.ServiceNameIsNotUniqueException;
import co.edu.uco.bodyhealty.servicios.domain.servicio.rules.ServiceNameIsUniqueRule;

@Service
public class ServiceNameIsUniqueRuleImpl implements  ServiceNameIsUniqueRule{

	private final ServicioRepository servicioRepository;
    private final ServicioEntityMapper servicioEntityMapper;

    public ServiceNameIsUniqueRuleImpl(ServicioRepository servicioRepository,
            final ServicioEntityMapper servicioEntityMapper) {
        this.servicioRepository = servicioRepository;
        this.servicioEntityMapper = servicioEntityMapper;
    }

    @Override
    public void validate(ServicioDomain data) {
        var serviceEntity = servicioEntityMapper.toEntity(data);
        if (servicioRepository.existsByName(serviceEntity.getNombreServicio())) {
            throw ServiceNameIsNotUniqueException.create(data.getNombreServicio());
        }
    }

}
