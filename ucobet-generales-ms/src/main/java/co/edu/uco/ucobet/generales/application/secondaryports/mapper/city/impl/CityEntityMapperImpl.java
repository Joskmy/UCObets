package co.edu.uco.ucobet.generales.application.secondaryports.mapper.city.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.city.CityEntityMapper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Component
public class CityEntityMapperImpl implements CityEntityMapper {
	private final ModelMapper modelMapper;

	public CityEntityMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CityDomain toDomain(CityEntity cityEntity) {
        return modelMapper.map(cityEntity, CityDomain.class);
    }

    @Override
    public CityEntity toEntity(CityDomain cityDomain) {
        return modelMapper.map(cityDomain, CityEntity.class);
    }
}
