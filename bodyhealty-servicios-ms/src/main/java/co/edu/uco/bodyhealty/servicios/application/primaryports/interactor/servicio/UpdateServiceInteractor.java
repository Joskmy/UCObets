package co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.InteractorWithoutReturnPut;

@Service
public interface UpdateServiceInteractor extends InteractorWithoutReturnPut <UUID, ServicioDTO> {

}
