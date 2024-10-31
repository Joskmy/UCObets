package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class StateDoesNotExistsException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;
	
	private StateDoesNotExistsException(final String userMessage) {
		super(userMessage,userMessage, new Exception());
	}
	
	public static final StateDoesNotExistsException create() {
		var userMessage = "No existe un estado con el id indicado...";
		return new StateDoesNotExistsException(userMessage);
	}
}
