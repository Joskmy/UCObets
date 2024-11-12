package co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;

public class ServiceDurationIsNotNullException extends RuleBodyHealtyException {

	private static final long serialVersionUID = 1L;

	private ServiceDurationIsNotNullException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static final ServiceDurationIsNotNullException create() {
		final var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00010);
		return new ServiceDurationIsNotNullException(userMessage);
	}

}