package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;

public class StateDoesNotExistsException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;
	
	private StateDoesNotExistsException(final String userMessage) {
		super(userMessage,userMessage, new Exception());
	}
	
	public static final StateDoesNotExistsException create() {
		var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00023);
		return new StateDoesNotExistsException(userMessage);
	}
}
