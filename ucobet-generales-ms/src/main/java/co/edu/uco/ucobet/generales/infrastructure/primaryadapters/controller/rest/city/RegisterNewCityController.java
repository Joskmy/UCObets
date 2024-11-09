package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.ApiResponse;

@RestController
@RequestMapping("/general/api/v1/cities")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000", "http://localhost:8080" })
public class RegisterNewCityController {

	private final RegisterNewCityInteractor registerNewCityInteractor;
    Logger logger = LoggerFactory.getLogger(this.getClass());


	public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityInteractor) {
		this.registerNewCityInteractor = registerNewCityInteractor;
	}

	@PostMapping
	public ResponseEntity<ApiResponse<RegisterNewCityDTO>> createCity(@RequestBody RegisterNewCityDTO dto) {
	    try {
	        System.out.println("Iniciando el proceso de creación de la ciudad: " + dto.getCityName());
	        System.out.println("DTO recibido: " + dto); // Imprimir DTO recibido

	        registerNewCityInteractor.execute(dto);
	        
	        System.out.println("Ciudad creada con éxito: " + dto.getCityName()); 


	        ApiResponse<RegisterNewCityDTO> response = new ApiResponse<>(HttpStatus.CREATED,
	                "Ciudad creada exitosamente", dto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);

	    } catch (JpaObjectRetrievalFailureException e) {
	        ApiResponse<RegisterNewCityDTO> response = new ApiResponse<>(HttpStatus.NOT_FOUND,
	                "Estado no encontrado con el ID proporcionado", null);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    } catch (DataIntegrityViolationException e) {
	        ApiResponse<RegisterNewCityDTO> response = new ApiResponse<>(HttpStatus.BAD_REQUEST,
	                "Violación de integridad de datos", null);
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    } catch (Exception e) {
	        ApiResponse<RegisterNewCityDTO> response = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,
	                "Error al crear la ciudad", null);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}


	@GetMapping
	public RegisterNewCityDTO executeDummy() {
		return RegisterNewCityDTO.create("Rionegro", UUIDHelper.generate());
	}
}
