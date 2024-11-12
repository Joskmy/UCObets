package co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions;


import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;

public class ServiceNameDoesNotExistException extends RuleBodyHealtyException {

	private static final long serialVersionUID = 1L;

    private ServiceNameDoesNotExistException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final ServiceNameDoesNotExistException create(String name) {
        final var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00024, name);
        return new ServiceNameDoesNotExistException(userMessage);
    }

}