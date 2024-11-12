package co.edu.uco.ucobet.generales.crosscutting.exceptions.message.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.CrosscuttingUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.MessageCatalog;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.Message;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;

public class MessageCatalogExternalService implements MessageCatalog {
	private final Map<String, Message> messages = new HashMap<>();

	@Override
	public final void initialize() {
		messages.clear();
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
			throw CrosscuttingUcobetException.create(userMessage, techMessage);
		}

		if (!code.isBase()) {
			var userMessage = getMessageContent(MessageCode.M00002);
			var techMessage = getMessageContent(MessageCode.M00005, code.getIdentifier());
			throw CrosscuttingUcobetException.create(userMessage, techMessage);
		}

		if (!messages.containsKey(code.getIdentifier())) {
			var userMessage = getMessageContent(MessageCode.M00002);
			var techMessage = getMessageContent(MessageCode.M00006, code.getIdentifier());
			throw CrosscuttingUcobetException.create(userMessage, techMessage);
		}

		return messages.get(code.getIdentifier());
	}

}
