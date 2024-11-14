package co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;


@Service
public interface GetServiceInteractor{
	ServicioDTO executeById(UUID id);
    List<ServicioDTO> executeByFilter(ServicioDTO filtro);
}
