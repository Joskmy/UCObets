package co.edu.uco.bodyhealty.servicios.domain.servicio.exceptions;


import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;

public class ServiceNameFormatIsNotValidException extends RuleBodyHealtyException {

	private static final long serialVersionUID = 1L;

    private ServiceNameFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final ServiceNameFormatIsNotValidException create() {
        final var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00028);
        return new ServiceNameFormatIsNotValidException(userMessage);
    }

}