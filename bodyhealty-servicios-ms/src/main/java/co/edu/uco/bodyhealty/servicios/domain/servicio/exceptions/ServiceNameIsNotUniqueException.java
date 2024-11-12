package co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions;


import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;

public class ServiceNameIsNotUniqueException extends RuleBodyHealtyException {

	private static final long serialVersionUID = 1L;

    private ServiceNameIsNotUniqueException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final ServiceNameIsNotUniqueException create(String name) {
        final var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00027, name);
        return new ServiceNameIsNotUniqueException(userMessage);
    }

}