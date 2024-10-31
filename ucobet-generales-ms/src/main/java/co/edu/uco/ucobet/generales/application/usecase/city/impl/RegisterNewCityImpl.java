package co.edu.uco.ucobet.generales.application.usecase.city.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.city.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;


@Service

public final class RegisterNewCityImpl implements RegisterNewCity {

	private CityRepository cityRepository;
	private RegisterNewCityRulesValidator registerNewCityRulesValidator;
    private  CityEntityMapper cityEntityMapper; 


	public RegisterNewCityImpl(final CityRepository cityRepository,
			final RegisterNewCityRulesValidator registerNewCityRulesValidator,
			final CityEntityMapper cityEntityMapper) {
		this.cityRepository = cityRepository;
		this.registerNewCityRulesValidator = registerNewCityRulesValidator;
        this.cityEntityMapper = cityEntityMapper;
	}

	@Override
	public void execute(final CityDomain domain) {

		// Rules Validation
		registerNewCityRulesValidator.validate(domain);

		// DataMapper -> Domain ->Entity
		CityEntity cityEntity = cityEntityMapper.toEntity(domain);

		// Save city Entity
		cityRepository.save(cityEntity);
		
		
		//Notificar Al administrados y lo demás min 1:36:00

	}

}
