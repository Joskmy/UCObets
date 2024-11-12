package co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.RegisterNewServiceInteractor;
import co.edu.uco.bodyhealty.servicios.application.primaryports.mapper.servicio.ServicioDTOmapper;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.registrar.RegisterNewService;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.ApplicationBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Service
public final class RegisterNewServiceInteractorImpl implements RegisterNewServiceInteractor {

	private RegisterNewService registerNewService;

	public RegisterNewServiceInteractorImpl(final RegisterNewService registerNewService) {
		this.registerNewService = registerNewService;
	}

	@Override
	public void execute(final ServicioDTO data) {
		try {
			ServicioDomain servicioDomain = ServicioDTOmapper.INSTANCE.toDomain(data);
			registerNewService.execute(servicioDomain);
		} catch (RuleBodyHealtyException ex) {
			throw ex;
		} catch (Exception ex) {
			final String userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00013,
					data.getNombreServicio());
			final String technicalMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00014,
					data.getNombreServicio());
			throw ApplicationBodyHealtyException.create(userMessage, technicalMessage, ex);
		}
	}
}
