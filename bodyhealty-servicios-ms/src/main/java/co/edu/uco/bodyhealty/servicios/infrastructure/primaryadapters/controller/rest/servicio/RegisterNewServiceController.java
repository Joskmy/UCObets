package co.edu.uco.bodyhealty.servicios.infrastructure.primaryadapters.controller.rest.servicio;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.RegisterNewServiceInteractor;
import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;

@RestController
@RequestMapping("/general/api/v1/services")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000", "http://localhost:8080" })
public class RegisterNewServiceController {

	private RegisterNewServiceInteractor registerNewServiceInteractor;

	public RegisterNewServiceController(final RegisterNewServiceInteractor registerNewServiceInteractor) {
		this.registerNewServiceInteractor = registerNewServiceInteractor;
	}

	@PostMapping
	public ServicioDTO execute(@RequestBody ServicioDTO dto) {
		System.out.println("Empiezo el proceso de POST");
		registerNewServiceInteractor.execute(dto);
		return dto;
	}
	
	@GetMapping
	public ServicioDTO executeDummy() {
		return ServicioDTO.create("Rionegro", 60, "hola");
	}

}
