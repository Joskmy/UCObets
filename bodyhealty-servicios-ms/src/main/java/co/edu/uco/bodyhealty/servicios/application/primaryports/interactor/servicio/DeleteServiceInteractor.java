package co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio;

import java.util.UUID;

import org.springframework.stereotype.Service;



@Service
public interface DeleteServiceInteractor {
	void execute(UUID id);
	
}

