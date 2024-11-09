package co.edu.uco.ucobet.generales.domain.city.exceptions;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;

public class CityNameForStateDoesExistException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

    private CityNameForStateDoesExistException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameForStateDoesExistException create(String cityName, UUID stateId) {
        var userMessage = String.format("La ciudad '%s' ya existe en el estado con ID: %s...", cityName, stateId);
        return new CityNameForStateDoesExistException(userMessage);
    }

}
