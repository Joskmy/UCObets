package co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.UpdateServiceInteractor;
import co.edu.uco.bodyhealty.servicios.application.primaryports.mapper.servicio.ServicioDTOmapper;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.actualizar.UpdateService;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.ApplicationBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Service
public class UpdateServiceInteractorImpl implements UpdateServiceInteractor {

	private UpdateService updateService;

	public UpdateServiceInteractorImpl(final UpdateService updateService) {
		this.updateService = updateService;
	}

	@Override
	public void execute(final String id, final ServicioDTO data) {
		try {
			UUID uuid = UUID.fromString(id);
			ServicioDomain servicioDomain = ServicioDTOmapper.INSTANCE.toDomainWithId(uuid, data);
			updateService.execute(servicioDomain);
		} catch (RuleBodyHealtyException ex) {
			throw ex;
		} catch (Exception ex) {
			final String userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00030,
					data.getNombreServicio());
			final String technicalMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00031,
					data.getNombreServicio());
			throw ApplicationBodyHealtyException.create(userMessage, technicalMessage, ex);
		}
	}

}
