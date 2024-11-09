package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;

public class CityIsBeingUsedException extends RuleUcobetException {

    private static final long serialVersionUID = 1L;

    private CityIsBeingUsedException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityIsBeingUsedException create() {
        var userMessage = "La ciudad está en uso...";
        return new CityIsBeingUsedException(userMessage);
    }
}
