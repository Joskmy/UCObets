package co.edu.uco.ucobet.generales.application.secondaryports.mapper.city;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

public interface CityEntityMapper {
	CityDomain toDomain(CityEntity cityEntity);
    CityEntity toEntity(CityDomain cityDomain);
}
