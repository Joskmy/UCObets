package co.edu.uco.bodyhealty.servicios.application.secondaryports.mapper.servicio;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import co.edu.uco.bodyhealty.servicios.application.secondaryports.entity.ServicioEntity;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Mapper(componentModel = "spring")
public interface ServicioEntityMapper {
	ServicioEntityMapper INSTANCE = Mappers.getMapper(ServicioEntityMapper.class);

    ServicioDomain toDomain(ServicioEntity servicioEntity);

    ServicioEntity toEntity(ServicioDomain servicioDomain);
}