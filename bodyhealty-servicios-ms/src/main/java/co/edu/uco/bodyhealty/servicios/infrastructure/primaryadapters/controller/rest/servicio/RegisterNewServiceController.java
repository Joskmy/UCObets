package co.edu.uco.bodyhealty.servicios.infrastructure.primaryadapters.controller.rest.servicio;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.RegisterNewServiceInteractor;
import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;

@RestController
@RequestMapping("/general/api/v1/services")

public class RegisterNewServiceController {

	private RegisterNewServiceInteractor registerNewServiceInteractor;

	public RegisterNewServiceController(final RegisterNewServiceInteractor registerNewServiceInteractor) {
		this.registerNewServiceInteractor = registerNewServiceInteractor;
	}

	@PostMapping
	public ServicioDTO execute(@RequestBody ServicioDTO dto) {
		registerNewServiceInteractor.execute(dto);
		return dto;
	}

}
