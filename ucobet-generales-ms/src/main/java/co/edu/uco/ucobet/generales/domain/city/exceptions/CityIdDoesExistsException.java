package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;

public class CityIdDoesExistsException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	private CityIdDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

	public static CityIdDoesExistsException create() {
		var userMessage = "Ya existe una ciudad con el ID proporcionado...";
		return new CityIdDoesExistsException(userMessage);
	}

}
