package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityNameFormatIsNotValidException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;
	
	private CityNameFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

	public static CityNameFormatIsNotValidException forNullName() {
        return new CityNameFormatIsNotValidException("El nombre de la ciudad no puede ser nulo...");
    }

    public static CityNameFormatIsNotValidException forEmptyName() {
        return new CityNameFormatIsNotValidException("El nombre de la ciudad no puede estar vacío...");
    }

    public static CityNameFormatIsNotValidException forShortName() {
        return new CityNameFormatIsNotValidException("El nombre de la ciudad debe tener al menos 50 caracteres.");
    }

}
