package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.city.CityMapper;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service
public final class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

	private final RegisterNewCity registerNewCity;
	private final CityMapper cityMapper;

	public RegisterNewCityInteractorImpl(final RegisterNewCity registerNewCity, CityMapper cityMapper) {
		this.registerNewCity = registerNewCity;
		this.cityMapper = cityMapper;
	}

	@Override
	public void execute(final RegisterNewCityDTO data) {
		CityDomain cityDomain = cityMapper.toDomain(data);
		registerNewCity.execute(cityDomain);
	}
}
