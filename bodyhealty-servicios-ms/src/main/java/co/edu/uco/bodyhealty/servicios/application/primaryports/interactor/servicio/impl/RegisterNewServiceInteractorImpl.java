package co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.RegisterNewServiceInteractor;
import co.edu.uco.bodyhealty.servicios.application.primaryports.mapper.servicio.ServicioDTOmapper;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.RegisterNewService;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;


@Service
public final  class RegisterNewServiceInteractorImpl implements RegisterNewServiceInteractor {
	
	private RegisterNewService registerNewService;

	public RegisterNewServiceInteractorImpl(final RegisterNewService registerNewService) {
		this.registerNewService = registerNewService;
	}

	@Override
	public void execute(final ServicioDTO data) {
		try {
			System.out.println("Iniciando el registro deL SERVICIO: " + data.getNombreServicio());
	        System.out.println("DTO recibido: " + data);
			ServicioDomain servicioDomain = ServicioDTOmapper.INSTANCE.toDomain(data);
			System.out.println("Se convirtió de DTO a domain");
	        System.out.println("DOMAIN recibido: " + servicioDomain);
	        registerNewService.execute(servicioDomain);
			System.out.println("Servicio Registrado  con éxito: " + data.getNombreServicio()); 
		} catch (Exception ex) {
			throw new RuntimeException("Error al crear la ciudad", ex);
		}
	}

}
