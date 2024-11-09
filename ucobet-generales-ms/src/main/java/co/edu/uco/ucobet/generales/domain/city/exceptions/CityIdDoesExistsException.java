package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;

public class CityIdDoesExistsException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	private CityIdDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

	public static CityIdDoesExistsException create() {
		
		var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00009);
		return new CityIdDoesExistsException(userMessage);
	}

}
