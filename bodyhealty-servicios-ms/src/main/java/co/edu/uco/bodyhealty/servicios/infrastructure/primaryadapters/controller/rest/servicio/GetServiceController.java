package co.edu.uco.bodyhealty.servicios.infrastructure.primaryadapters.controller.rest.servicio;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.GetServiceInteractor;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.NumericHelper;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;
import co.edu.uco.bodyhealty.servicios.infrastructure.primaryadapters.responses.impl.ServicioResponse;

@RestController
@RequestMapping("/general/api/v1/services")

public class GetServiceController {
	private GetServiceInteractor getServiceInteractor;

	public GetServiceController(final GetServiceInteractor getServiceInteractor) {
		this.getServiceInteractor = getServiceInteractor;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ServicioResponse> consultarPorId(@PathVariable UUID id) {
		ServicioResponse servicioResponse = ServicioResponse.build();
		HttpStatus httpStatusResponse = HttpStatus.OK;

		try {
			ServicioDTO servicio = getServiceInteractor.executeById(id);
			servicioResponse.getDatos().add(servicio);
			servicioResponse.getMensajes().add(MessageCatalogStrategy.getContentMessage(MessageCode.M00036));
		} catch (final RuleBodyHealtyException exception) {
			exception.printStackTrace();
			httpStatusResponse = HttpStatus.BAD_REQUEST;
			servicioResponse.getMensajes().add(exception.getUserMessage());
		} catch (final Exception exception) {
			exception.printStackTrace();
			httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
			servicioResponse.getMensajes().add(MessageCatalogStrategy.getContentMessage(MessageCode.M00037));
		}
		return new ResponseEntity<>(servicioResponse, httpStatusResponse);
	}

	@GetMapping
	public ResponseEntity<ServicioResponse> consultarPorFiltros(@RequestParam(required = false) String nombre,
			@RequestParam(required = false) Integer duracion) {
		ServicioResponse servicioResponse = ServicioResponse.build();
		HttpStatus httpStatusResponse = HttpStatus.OK;

		try {
			String nombreFiltro = TextHelper.applyTrim(nombre);
			int duracionFiltro = ObjectHelper.getDefault(duracion, NumericHelper.ZERO);
			String descripcionFiltro = TextHelper.EMPTY;

			ServicioDTO filtro = ServicioDTO.create(nombreFiltro, duracionFiltro, descripcionFiltro);

			List<ServicioDTO> servicios = getServiceInteractor.executeByFilter(filtro);

			if (servicios.isEmpty()) {
				servicioResponse.getMensajes().add(MessageCatalogStrategy.getContentMessage(MessageCode.M00040));
			} else {
				servicioResponse.getDatos().addAll(servicios);
				servicioResponse.getMensajes().add(MessageCatalogStrategy.getContentMessage(MessageCode.M00036));
			}
		} catch (final RuleBodyHealtyException exception) {
			exception.printStackTrace();
			httpStatusResponse = HttpStatus.BAD_REQUEST;
			servicioResponse.getMensajes().add(exception.getUserMessage());
		}
		return new ResponseEntity<>(servicioResponse, httpStatusResponse);
	}
}