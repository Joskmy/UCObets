package co.edu.uco.ucobet.generales.application.primaryports.mapper.city;


import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

public interface CityMapper {

	CityDomain toDomain(RegisterNewCityDTO cityDTO);

	RegisterNewCityDTO toDTO(CityDomain cityDomain);
}
