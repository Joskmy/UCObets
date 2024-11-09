package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.city.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice.EmailService;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

	private CityRepository cityRepository;
    private final EmailService emailService;
	private RegisterNewCityRulesValidator registerNewCityRulesValidator;

	public RegisterNewCityImpl(final CityRepository cityRepository,
			final  EmailService emailService,
			final RegisterNewCityRulesValidator registerNewCityRulesValidator) {
		this.cityRepository = cityRepository;
		this.emailService = emailService;
		this.registerNewCityRulesValidator = registerNewCityRulesValidator;
	}

	@Override
	public void execute(final CityDomain domain) {

		// Rules validation
		registerNewCityRulesValidator.validate(domain);

		// DataMapper -> Domain -> Entity
		System.out.println("se inció el proceso de DOMAIN a Entity {}" + domain);

		final CityEntity cityEntity = CityEntityMapper.INSTANCE.domainToEntity(domain);

		System.out.println("Se logró transformar de DOMAIN a Entity");

		System.out.println("El Entity se ve: " + cityEntity.toString());

		System.out.println("Empieza el proceso de guardado");
		cityRepository.save(cityEntity);
		System.out.println("Se logró Guardar CityEntity" + domain.getName());
		try {
			emailService.notificarNuevaCiudad(domain.getName());
            System.out.println("Correo de notificación enviado exitosamente para la ciudad: " + domain.getName());
        } catch (Exception e) {
            System.err.println("Error al enviar el correo de notificación: " + e.getMessage());
        }

	}

}
