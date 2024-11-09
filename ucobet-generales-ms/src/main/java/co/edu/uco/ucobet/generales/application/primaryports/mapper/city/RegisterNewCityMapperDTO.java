package co.edu.uco.ucobet.generales.application.primaryports.mapper.city;

import java.util.UUID;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
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

    @BeforeMapping
    default void beforeMapping(RegisterNewCityDTO dto) {
        // Depura el estado del DTO antes de hacer el mapeo
        System.out.println("Estado recibido en DTO: " + dto.getStateId());
    }

    @Mapping(source = "cityName", target = "name")
    @Mapping(source = "stateId", target = "state", qualifiedByName = "mapToStateDomain")
    @Mapping(target = "id", expression = "java(UUIDHelper.generate())")
    CityDomain toDomain(RegisterNewCityDTO dto);

    @Named("mapToStateDomain")
    default StateDomain mapToStateDomain(UUID stateId) {
        // Verifica el valor de stateId antes de crear el StateDomain
        System.out.println("Creando StateDomain con stateId: " + stateId);
        
        return new StateDomain(stateId, "Hola", null);
    }

    @AfterMapping
    default void afterMapping(CityDomain cityDomain) {
        // Verifica el valor de 'state' después de hacer el mapeo
        if (cityDomain.getState() == null) {
            System.out.println("El estado es nulo después del mapeo, revisa si se asignó correctamente");
        } else {
            System.out.println("Estado en el CityDomain después del mapeo: " + cityDomain.getState());
        }
    }
}
