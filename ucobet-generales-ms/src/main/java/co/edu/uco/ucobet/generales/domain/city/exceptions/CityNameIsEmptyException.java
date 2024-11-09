package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;

public class CityNameIsEmptyException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	private CityNameIsEmptyException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }


	public static CityNameIsEmptyException create(){
		var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00016);
		return new CityNameIsEmptyException(userMessage);
	}

	

}
