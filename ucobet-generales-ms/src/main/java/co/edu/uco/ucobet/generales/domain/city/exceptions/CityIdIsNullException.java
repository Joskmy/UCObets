package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;

public class CityIdIsNullException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

    private CityIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityIdIsNullException create() {
        var userMessage = "El id de la ciudad no puede ser nulo...";
        return new CityIdIsNullException(userMessage);
    }
	
	

}
