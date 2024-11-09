package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;

public class CityStateDoesNotExistsException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;
	
	private CityStateDoesNotExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

	public static CityStateDoesNotExistsException create() {
		var userMessage = "Ya existe un estado con el ID proporcionado...";
		return new CityStateDoesNotExistsException(userMessage);
	}

}
