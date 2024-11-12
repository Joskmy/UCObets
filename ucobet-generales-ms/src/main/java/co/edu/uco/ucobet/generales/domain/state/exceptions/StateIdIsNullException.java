package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;

public class StateIdIsNullException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

    private StateIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final StateIdIsNullException create() {
    	var userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00024);
        return new StateIdIsNullException(userMessage);
    }
	
	

}
