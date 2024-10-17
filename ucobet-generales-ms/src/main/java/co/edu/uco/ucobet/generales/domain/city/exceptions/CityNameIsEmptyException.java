package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityNameIsEmptyException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	private CityNameIsEmptyException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }


	public static CityNameIsEmptyException create(){
		var userMessage = "El nombre de la ciudad no puede estar vacio...";
		return new CityNameIsEmptyException(userMessage);
	}

	

}
