package co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions;

import java.util.UUID;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;

public class ServiceIsUsedException extends RuleBodyHealtyException {

	private static final long serialVersionUID = 1L;

    private ServiceIsUsedException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final ServiceIsUsedException create(UUID id) {
        final var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00018, id.toString());
        return new ServiceIsUsedException(userMessage);
    }

}