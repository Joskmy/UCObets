package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;

public class CityNameFormatIsNotValidException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;
	
	private CityNameFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameFormatIsNotValidException forInvalidFormat() {
        return new CityNameFormatIsNotValidException("El nombre de la ciudad solo puede contener letras y espacios(con y sin tílde)");
    }

}
