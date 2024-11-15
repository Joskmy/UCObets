package co.edu.uco.bodyhealty.servicios.infrastructure.primaryadapters.controller.rest.servicio;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.UpdateServiceInteractor;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.ApplicationBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.servicios.infrastructure.primaryadapters.responses.impl.ServicioResponse;

@RestController
@RequestMapping("/general/api/v1/services")

public class UpdateServiceController {

	private UpdateServiceInteractor updateServiceInteractor;

	public UpdateServiceController(final UpdateServiceInteractor updateServiceInteractor) {
		this.updateServiceInteractor = updateServiceInteractor;
	}

	@PutMapping("/{id}")
	public ResponseEntity<ServicioResponse> actualizarPorId(@PathVariable UUID id, @RequestBody ServicioDTO dto) {
		ServicioResponse servicioResponse = ServicioResponse.build();
		HttpStatus httpStatusResponse = HttpStatus.OK;

		try {
			updateServiceInteractor.execute(id, dto);
			servicioResponse.getDatos().add(dto);
			servicioResponse.getMensajes()
					.add(MessageCatalogStrategy.getContentMessage(MessageCode.M00032, id.toString()));
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
			servicioResponse.getMensajes().add(MessageCatalogStrategy.getContentMessage(MessageCode.M00030));
		}

		return new ResponseEntity<>(servicioResponse, httpStatusResponse);
	}
}