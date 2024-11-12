package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.Message;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;

public interface MessageCatalog {

	void initialize();

	String getMessageContent(final MessageCode code, String... parameters);

	Message getMessage(final MessageCode code, String... parameters);

}