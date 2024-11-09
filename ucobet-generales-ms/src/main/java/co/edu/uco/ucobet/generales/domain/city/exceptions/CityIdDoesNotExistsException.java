package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;

public class CityIdDoesNotExistsException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;
	
	private CityIdDoesNotExistsException(final String userMessage) {
		super(userMessage,userMessage, new Exception());
	}
	
	public static final CityIdDoesNotExistsException create() {
		var userMessage = "No existe la ciudad con el id indicado...";
		return new CityIdDoesNotExistsException(userMessage);
	}
}
