package co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions;


import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;

public class ServiceNameIsNullException extends RuleBodyHealtyException {

	private static final long serialVersionUID = 1L;

    private ServiceNameIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final ServiceNameIsNullException create() {
        final var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00026);
        return new ServiceNameIsNullException(userMessage);
    }

}