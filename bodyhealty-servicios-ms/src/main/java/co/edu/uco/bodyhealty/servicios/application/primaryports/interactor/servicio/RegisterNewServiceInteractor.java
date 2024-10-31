package co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.InteractorWithoutReturn;
import jakarta.transaction.Transactional;

@Service
@Transactional

public interface RegisterNewServiceInteractor extends InteractorWithoutReturn<ServicioDTO> {

}
