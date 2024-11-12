package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.entity.ServicioEntity;
import co.edu.uco.bodyhealty.servicios.application.secondaryports.mapper.servicio.ServicioEntityMapper;
import co.edu.uco.bodyhealty.servicios.application.secondaryports.repository.ServicioRepository;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.RegisterNewService;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.RegisterNewServiceRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;


@Service
public class RegisterNewServiceImpl implements RegisterNewService {


	private ServicioRepository servicioRepository;
	private RegisterNewServiceRulesValidator registerNewServiceRulesValidator;



	public RegisterNewServiceImpl(final ServicioRepository servicioRepository, final RegisterNewServiceRulesValidator registerNewServiceRulesValidator ) {
		this.servicioRepository = servicioRepository;
		this.registerNewServiceRulesValidator = registerNewServiceRulesValidator;

	}



	@Override
	public void execute(final ServicioDomain domain) {

		// Rules validation
		registerNewServiceRulesValidator.validate(domain);

		final ServicioEntity servicioEntity = ServicioEntityMapper.INSTANCE.toEntity(domain);
		servicioRepository.save(servicioEntity);


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
