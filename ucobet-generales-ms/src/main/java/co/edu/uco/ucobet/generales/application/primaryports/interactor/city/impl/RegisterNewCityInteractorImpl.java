package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.city.RegisterNewCityMapperDTO;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.ApplicationUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

	private RegisterNewCity registerNewCity;

	public RegisterNewCityInteractorImpl(final RegisterNewCity registerNewCity) {
		this.registerNewCity = registerNewCity;
	}

	@Override
	public void execute(final RegisterNewCityDTO data) {
		try {
			CityDomain cityDomain = RegisterNewCityMapperDTO.INSTANCE.toDomain(data);
			registerNewCity.execute(cityDomain); 
		} catch (ApplicationUcobetException exception) {
			throw ApplicationUcobetException.create(MessageCatalogStrategy.getContentMessage(MessageCode.M00020));
		}
	}
}