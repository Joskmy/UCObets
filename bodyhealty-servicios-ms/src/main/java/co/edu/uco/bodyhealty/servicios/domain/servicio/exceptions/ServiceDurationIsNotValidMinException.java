package co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;

public class ServiceDurationIsNotValidMinException extends RuleBodyHealtyException {

	private static final long serialVersionUID = 1L;

	private ServiceDurationIsNotValidMinException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static final ServiceDurationIsNotValidMinException create() {
		final var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00012);
		return new ServiceDurationIsNotValidMinException(userMessage);
	}

}
