package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;

public class StateIdIsNullException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

    private StateIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final StateIdIsNullException create() {
        var userMessage = "El id del estado no puede ser nulo...";
        return new StateIdIsNullException(userMessage);
    }
	
	

}
