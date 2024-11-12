package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

@RestController
@RequestMapping("/general/api/v1/cities")
@CrossOrigin(
    origins = {"https://localhost:3000", "http://localhost:3000"}, 
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS},
    allowedHeaders = {"Origin", "Content-Type", "Accept", "Authorization"},
    allowCredentials = "true"
)
public class RegisterNewCityController {

	private final RegisterNewCityInteractor registerNewCityInteractor;


	public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityInteractor) {
		this.registerNewCityInteractor = registerNewCityInteractor;
	}

	@PostMapping
	public RegisterNewCityDTO execute(@RequestBody RegisterNewCityDTO dto) {
		System.out.println("Empiezo el proceso de POST");
		registerNewCityInteractor.execute(dto);
		return dto;
	}

	@GetMapping
	public RegisterNewCityDTO executeDummy() {
		return RegisterNewCityDTO.create("Rionegro", UUIDHelper.generate());
	}
}
