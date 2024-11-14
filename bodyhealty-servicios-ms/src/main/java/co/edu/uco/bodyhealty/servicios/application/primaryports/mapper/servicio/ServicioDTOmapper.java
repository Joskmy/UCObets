package co.edu.uco.bodyhealty.servicios.application.primaryports.mapper.servicio;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.UUIDHelper;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Mapper(componentModel = "spring", imports = { UUID.class, UUIDHelper.class })
public interface ServicioDTOmapper {
    ServicioDTOmapper INSTANCE = Mappers.getMapper(ServicioDTOmapper.class);

    @Mapping(target = "id", expression = "java(UUIDHelper.generate())")
    ServicioDomain toDomain(ServicioDTO dto);
    
    @Mapping(target = "id", source = "id")
    ServicioDomain toDomainWithId(UUID id, ServicioDTO dto);
    
    @Mapping(target = "nombreServicio", ignore = true)
    @Mapping(target = "duracionEstimada", constant = "0")
    @Mapping(target = "descripcion", ignore = true)
    ServicioDomain toDomainOnlyId(UUID id);

    @Mapping(source = "nombreServicio", target = "nombreServicio")
    @Mapping(source = "duracionEstimada", target = "duracionEstimada")
    @Mapping(source = "descripcion", target = "descripcion")
    ServicioDTO toDTO(ServicioDomain domain);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "nombreServicio", target = "nombreServicio")
    @Mapping(source = "duracionEstimada", target = "duracionEstimada")
    @Mapping(source = "descripcion", target = "descripcion")
    ServicioDomain toDomainForFilter(ServicioDTO dto);
}