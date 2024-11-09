package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;

public class CityIdIsNullException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

    private CityIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityIdIsNullException create() {
        var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00010);
        return new CityIdIsNullException(userMessage);
    }
	
	

}
