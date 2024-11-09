package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.city.RegisterNewCityMapperDTO;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service
@Transactional
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

	private RegisterNewCity registerNewCity;

	public RegisterNewCityInteractorImpl(final RegisterNewCity registerNewCity) {
		this.registerNewCity = registerNewCity;
	}

	@Override
	public void execute(final RegisterNewCityDTO data) {
		try {
			System.out.println("Iniciando el registro de la ciudad::::: {}" + data.getCityName());
	        System.out.println("DTO recibido: " + data);
			CityDomain cityDomain = RegisterNewCityMapperDTO.INSTANCE.toDomain(data);
			System.out.println("Se convirtió de DTO a domain" + data.getCityName());
	        System.out.println("DOMAIN recibido: " + cityDomain);
			registerNewCity.execute(cityDomain); // Registro de la ciudad
			System.out.println("Ciudad registrada con éxito: {}" + data.getCityName()); // Log de éxito
		} catch (Exception ex) {
			throw new RuntimeException("Error al crear la ciudad", ex);
		}
	}
}