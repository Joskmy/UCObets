package co.edu.uco.bodyhealty.servicios.application.secondaryports.mapper.servicio.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.entity.ServicioEntity;
import co.edu.uco.bodyhealty.servicios.application.secondaryports.mapper.servicio.ServicioEntityMapper;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Component
public class ServicioEntityMapperImpl implements ServicioEntityMapper {
	private final ModelMapper modelMapper;

	public ServicioEntityMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public ServicioDomain toDomain(ServicioEntity servicioEntity) {
		return modelMapper.map(servicioEntity, ServicioDomain.class);
	}

	@Override
	public ServicioEntity toEntity(ServicioDomain servicioDomain) {
		return modelMapper.map(servicioDomain, ServicioEntity.class);

	}

}
