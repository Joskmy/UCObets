package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityNameLenghtIsNotValidException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;
	
	private CityNameLenghtIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }
	

	public static CityNameLenghtIsNotValidException create() {
		var userMessage = "El nombre de la ciudad debe tener al menos 255 caracteres...";
		return new CityNameLenghtIsNotValidException(userMessage);
    }

}
