package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;

public class CityStateDoesNotExistsException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;
	
	private CityStateDoesNotExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

	public static CityStateDoesNotExistsException create() {
		var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00019);
		return new CityStateDoesNotExistsException(userMessage);
	}

}
