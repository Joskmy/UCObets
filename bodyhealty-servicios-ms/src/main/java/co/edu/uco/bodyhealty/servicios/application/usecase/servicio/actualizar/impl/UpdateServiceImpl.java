package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.actualizar.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.entity.ServicioEntity;
import co.edu.uco.bodyhealty.servicios.application.secondaryports.mapper.servicio.ServicioEntityMapper;
import co.edu.uco.bodyhealty.servicios.application.secondaryports.repository.ServicioRepository;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.actualizar.UpdateService;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.actualizar.UpdateServiceRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;


@Service
public class UpdateServiceImpl implements UpdateService {


	private ServicioRepository servicioRepository;
	private UpdateServiceRulesValidator updateServiceRulesValidator;



	public UpdateServiceImpl(final ServicioRepository servicioRepository, final UpdateServiceRulesValidator updateServiceRulesValidator ) {
		this.servicioRepository = servicioRepository;
		this.updateServiceRulesValidator = updateServiceRulesValidator;

	}



	@Override
    public void execute(final ServicioDomain domain) {
        updateServiceRulesValidator.validate(domain);
        
        final ServicioEntity servicioEntity = ServicioEntityMapper.INSTANCE.toEntity(domain);
        servicioRepository.save(servicioEntity);
    }

}


