package co.edu.uco.ucobet.generales.domain.city.exceptions;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;

public class CityNameForStateDoesExistException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

    private CityNameForStateDoesExistException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameForStateDoesExistException create(String cityName, UUID stateId) {
        var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00015);
        return new CityNameForStateDoesExistException(userMessage);
    }

}
