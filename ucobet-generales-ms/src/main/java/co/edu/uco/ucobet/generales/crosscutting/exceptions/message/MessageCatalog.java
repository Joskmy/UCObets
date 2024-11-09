package co.edu.uco.ucobet.generales.crosscutting.exceptions.message;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.Message;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;

public interface MessageCatalog {

	void initialize();

	String getMessageContent(final MessageCode code, String... parameters);

	Message getMessage(final MessageCode code, String... parameters);

}
