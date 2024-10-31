package co.edu.uco.ucobet.generales.application.primaryports.mapper.city.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.city.CityMapper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;


@Component
public class CityMapperImpl implements CityMapper{
	
	private final ModelMapper modelMapper;
	
	public CityMapperImpl() {
        this.modelMapper = new ModelMapper();
    }

	@Override
    public CityDomain toDomain(RegisterNewCityDTO cityDTO) {
        return modelMapper.map(cityDTO, CityDomain.class);
    }

    @Override
    public RegisterNewCityDTO toDTO(CityDomain cityDomain) {
        return modelMapper.map(cityDomain, RegisterNewCityDTO.class);
    }

}
