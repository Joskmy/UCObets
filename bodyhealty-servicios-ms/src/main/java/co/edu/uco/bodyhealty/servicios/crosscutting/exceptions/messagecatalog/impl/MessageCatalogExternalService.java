package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.Message;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.ObjectHelper;

public class MessageCatalogExternalService implements MessageCatalog {
	private final Map<String, Message> messages = new HashMap<>();

	@Override
	public final void initialize() {
		messages.clear();
		// TODO: FALTAN LOS MENSAJES personalizados externos
	}

	@Override
	public final String getMessageContent(final MessageCode code, final String... parameters) {
		return getMessage(code, parameters).getContent();
	}

	@Override
	public final Message getMessage(final MessageCode code, final String... parameters) {

		if (ObjectHelper.isNull(code)) {
			var userMessage = getMessageContent(MessageCode.M00002);
			var techMessage = getMessageContent(MessageCode.M00001);
			throw RuleBodyHealtyException.create(userMessage, techMessage);
		}

		if (!code.isBase()) {
			var userMessage = getMessageContent(MessageCode.M00002);
			var techMessage = getMessageContent(MessageCode.M00005, code.getIdentifier());
			throw RuleBodyHealtyException.create(userMessage, techMessage);
		}

		if (!messages.containsKey(code.getIdentifier())) {
			var userMessage = getMessageContent(MessageCode.M00002);
			var techMessage = getMessageContent(MessageCode.M00006, code.getIdentifier());
			throw RuleBodyHealtyException.create(userMessage, techMessage);
		}

		return messages.get(code.getIdentifier());
	}

}
