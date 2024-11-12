package co.edu.uco.bodyhealty.servicios.infrastructure.primaryadapters.controller.rest.servicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.RegisterNewServiceInteractor;
import co.edu.uco.bodyhealty.servicios.application.responses.impl.ServicioResponse;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.BodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.ApplicationBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;

@RestController
@RequestMapping("/general/api/v1/services")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000", "http://localhost:8080" })
public class RegisterNewServiceController {

	private RegisterNewServiceInteractor registerNewServiceInteractor;

	public RegisterNewServiceController(final RegisterNewServiceInteractor registerNewServiceInteractor) {
		this.registerNewServiceInteractor = registerNewServiceInteractor;
	}

	@PostMapping
    public ResponseEntity<ServicioResponse> crear(@RequestBody ServicioDTO dto) {
        ServicioResponse servicioResponse = ServicioResponse.build();
        HttpStatus httpStatusResponse = HttpStatus.OK;

        try {
    		registerNewServiceInteractor.execute(dto);
    		servicioResponse.getDatos().add(dto);
            servicioResponse.getMensajes().add(MessageCatalogStrategy.getContentMessage(MessageCode.M00007, dto.getNombreServicio()));

        } catch (final ApplicationBodyHealtyException exception) {
        	System.out.println("Entro por ApplicationBodyHealtyException");
            exception.printStackTrace();
            servicioResponse.getMensajes().add(exception.getUserMessage());
            httpStatusResponse = HttpStatus.BAD_REQUEST;
        } catch (final BodyHealtyException exception) {
        	System.out.println("Entro por BodyHealtyException");
            exception.printStackTrace();
            servicioResponse.getMensajes().add(exception.getUserMessage());
            httpStatusResponse = HttpStatus.BAD_REQUEST;
        } catch (final Exception exception) {
        	System.out.println("Entro por Exception");
            exception.printStackTrace();
            servicioResponse.getMensajes().add(MessageCatalogStrategy.getContentMessage(MessageCode.M00005));
            httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(servicioResponse, httpStatusResponse);
    }

	@GetMapping
	public ServicioDTO executeDummy() {
		return ServicioDTO.create("Rionegro", 60, "hola");
	}

}
