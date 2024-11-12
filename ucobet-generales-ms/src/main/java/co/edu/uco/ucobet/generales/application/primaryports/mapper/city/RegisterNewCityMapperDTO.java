package co.edu.uco.ucobet.generales.application.primaryports.mapper.city;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Mapper(componentModel = "spring", imports = { UUID.class, UUIDHelper.class })
public interface RegisterNewCityMapperDTO {
    RegisterNewCityMapperDTO INSTANCE = Mappers.getMapper(RegisterNewCityMapperDTO.class);

    

    @Mapping(source = "cityName", target = "name")
    @Mapping(source = "stateId", target = "state", qualifiedByName = "mapToStateDomain")
    @Mapping(target = "id", expression = "java(UUIDHelper.generate())")
    CityDomain toDomain(RegisterNewCityDTO dto);

    @Named("mapToStateDomain")
    default StateDomain mapToStateDomain(UUID stateId) {
        
        return new StateDomain(stateId, "Hola", null);
    }

}
