package co.edu.uco.bodyhealty.servicios.infrastructure.primaryadapters.controller.rest.servicio;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.DeleteServiceInteractor;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.ApplicationBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.servicios.infrastructure.primaryadapters.responses.impl.ServicioResponse;

@RestController
@RequestMapping("/general/api/v1/services")

public class DeleteServiceController {

	private DeleteServiceInteractor deleteServiceInteractor;

	public DeleteServiceController(final DeleteServiceInteractor deleteServiceInteractor) {
		this.deleteServiceInteractor = deleteServiceInteractor;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ServicioResponse> eliminarPorId(@PathVariable UUID id) {
		ServicioResponse servicioResponse = ServicioResponse.build();
		HttpStatus httpStatusResponse = HttpStatus.OK;

		try {
			deleteServiceInteractor.execute(id);
			servicioResponse.getMensajes()
					.add(MessageCatalogStrategy.getContentMessage(MessageCode.M00034, id.toString()));
		} catch (final RuleBodyHealtyException exception) {
			exception.printStackTrace();
			httpStatusResponse = HttpStatus.BAD_REQUEST;
			servicioResponse.getMensajes().add(exception.getUserMessage());
		} catch (final ApplicationBodyHealtyException exception) {
			exception.printStackTrace();
			httpStatusResponse = HttpStatus.BAD_REQUEST;
			servicioResponse.getMensajes().add(exception.getUserMessage());
		} catch (final Exception exception) {
			exception.printStackTrace();
			httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
			servicioResponse.getMensajes().add(MessageCatalogStrategy.getContentMessage(MessageCode.M00035));
		}

		return new ResponseEntity<>(servicioResponse, httpStatusResponse);
	}
}