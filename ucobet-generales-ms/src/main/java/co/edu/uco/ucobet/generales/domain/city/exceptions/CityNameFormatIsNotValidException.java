package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;

public class CityNameFormatIsNotValidException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;
	
	private CityNameFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameFormatIsNotValidException forInvalidFormat() {
        var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00014);
        return new CityNameFormatIsNotValidException(userMessage);
    }

}
