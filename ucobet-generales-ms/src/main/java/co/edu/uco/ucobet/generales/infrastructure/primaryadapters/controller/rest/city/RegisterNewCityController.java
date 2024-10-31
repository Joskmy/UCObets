package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

@RestController
@RequestMapping("/general/api/v1/cities")
public class RegisterNewCityController {
	private RegisterNewCityInteractor registerNewCityInteractor;

	public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityInteractor) {
		this.registerNewCityInteractor = registerNewCityInteractor;
	}

	@PostMapping
	public RegisterNewCityDTO execute(@RequestBody RegisterNewCityDTO dto) {
		registerNewCityInteractor.execute(dto);

		return dto;

	}

	@GetMapping
	public RegisterNewCityDTO executeDummy() {
		return RegisterNewCityDTO.create("Rionegro", UUIDHelper.generate());
	}
}
