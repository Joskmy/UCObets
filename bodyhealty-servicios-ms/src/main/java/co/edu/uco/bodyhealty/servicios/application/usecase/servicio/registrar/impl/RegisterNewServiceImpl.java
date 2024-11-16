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

	}


}
