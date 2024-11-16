package co.edu.uco.bodyhealty.servicios.infrastructure.primaryadapters.controller.rest.servicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.RegisterNewServiceInteractor;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.BodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.ApplicationBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.servicios.infrastructure.primaryadapters.responses.impl.ServicioResponse;

@RestController
@RequestMapping("/general/api/v1/services")

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
			String nombreOriginal = dto.getNombreServicio();
			registerNewServiceInteractor.execute(dto);
			servicioResponse.getDatos().add(dto);
			servicioResponse.getMensajes()
					.add(MessageCatalogStrategy.getContentMessage(MessageCode.M00007, nombreOriginal));

		} catch (final ApplicationBodyHealtyException exception) {
			exception.printStackTrace();
			servicioResponse.getMensajes().add(exception.getUserMessage());
			httpStatusResponse = HttpStatus.BAD_REQUEST;
		} catch (final BodyHealtyException exception) {
			exception.printStackTrace();
			servicioResponse.getMensajes().add(exception.getUserMessage());
			httpStatusResponse = HttpStatus.BAD_REQUEST;
		} catch (final Exception exception) {
			exception.printStackTrace();
			servicioResponse.getMensajes().add(MessageCatalogStrategy.getContentMessage(MessageCode.M00005));
			httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(servicioResponse, httpStatusResponse);
	}

}