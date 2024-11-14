package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.eliminar.impl;

import org.springframework.stereotype.Service;


import co.edu.uco.bodyhealty.servicios.application.secondaryports.repository.ServicioRepository;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.eliminar.DeleteService;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.eliminar.DeleteServiceRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Service
public class DeleteServiceImpl implements DeleteService {

	private ServicioRepository servicioRepository;
	private DeleteServiceRulesValidator deleteServiceRulesValidator;

	public DeleteServiceImpl(final ServicioRepository servicioRepository,
			final DeleteServiceRulesValidator deleteServiceRulesValidator) {
		this.servicioRepository = servicioRepository;
		this.deleteServiceRulesValidator = deleteServiceRulesValidator;

	}

	@Override
	public void execute(final ServicioDomain domain) {
		deleteServiceRulesValidator.validate(domain);
		servicioRepository.deleteById(domain.getId());
	}

}
