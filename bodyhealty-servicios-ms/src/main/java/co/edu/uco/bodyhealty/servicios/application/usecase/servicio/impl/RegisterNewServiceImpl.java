package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.entity.ServicioEntity;
import co.edu.uco.bodyhealty.servicios.application.secondaryports.mapper.servicio.ServicioEntityMapper;
import co.edu.uco.bodyhealty.servicios.application.secondaryports.repository.ServicioRepository;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.RegisterNewService;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;


@Service
public class RegisterNewServiceImpl implements RegisterNewService {
	
	
	private ServicioRepository servicioRepository;
	
	//TODO: PONER RULES VALIDATOR

	public RegisterNewServiceImpl(final ServicioRepository servicioRepository) {
		super();
		this.servicioRepository = servicioRepository;
	}



	@Override
	public void execute(final ServicioDomain domain) {

		// Rules validation

		// DataMapper -> Domain -> Entity
		System.out.println("se inció el proceso de DOMAIN a Entity" + domain);

		final ServicioEntity servicioEntity = ServicioEntityMapper.INSTANCE.toEntity(domain);
		
		System.out.println("Se logró transformar de DOMAIN a Entity");
		
		System.out.println("El Entity se ve: " + servicioEntity.toString());
		
		System.out.println("Empieza el proceso de guardado");
		servicioRepository.save(servicioEntity);
		System.out.println("Se logró Guardar LA CIUDAD" + domain.getNombreServicio() + "En la la base de datos"); 


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
