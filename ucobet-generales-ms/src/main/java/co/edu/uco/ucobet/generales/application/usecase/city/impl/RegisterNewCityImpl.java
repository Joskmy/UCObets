package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.city.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import jakarta.transaction.Transactional;


@Transactional
@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

	private CityRepository cityRepository;
	//private RegisterNewCityRulesValidator registerNewCityRulesValidator;

	public RegisterNewCityImpl(final CityRepository cityRepository,
			final RegisterNewCityRulesValidator registerNewCityRulesValidator) {
		this.cityRepository = cityRepository;
		//this.registerNewCityRulesValidator = registerNewCityRulesValidator;
	}

	@Override
	public void execute(final CityDomain domain) {

		// Rules validation
		//registerNewCityRulesValidator.validate(domain);

		// DataMapper -> Domain -> Entity
		System.out.println("se inció el proceso de DOMAIN a Entity {}" + domain);

		final CityEntity cityEntity = CityEntityMapper.INSTANCE.domainToEntity(domain);
		
		System.out.println("Se logró transformar de DOMAIN a Entity");
		
		System.out.println("El Entity se ve: " + cityEntity.toString());
		
		System.out.println("Empieza el proceso de guardado");
		cityRepository.save(cityEntity);
		System.out.println("Se logró Guardar CityEntity" + domain.getName()); 


		// Notificar al administrador sobre la creación de la nueva ciudad
		// : ¿Cómo? Notification Building Block

		// Tenga en cuenta que:
		// 1. El correo del administrador está en un lugar parametrizado (Parameters
		// Building Block)
		// 2. El asunto del correo está en un lugar parametrizado (Parameters Building
		// Block)
		// 3. El cuerpo del correo está en un lugar parametrizado (Parameters Building
		// Block)
	}


}
