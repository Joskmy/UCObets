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
		messages.put(MessageCode.M00022.getIdentifier(), new Message(MessageCode.M00022,
				"Ha ocurrido un error inesperado en la transacciòn elaborada..."));
		messages.put(MessageCode.M00023.getIdentifier(), new Message(MessageCode.M00023,
				"Error al consultar por el Filtro Correspondiente a la Acciòn en la capa de ServicioRepositoryCustom..."));
		messages.put(MessageCode.M00024.getIdentifier(), new Message(MessageCode.M00025,
				"Error al verificar la existencia del servicio con nombre: {1}..."));
		messages.put(MessageCode.M00025.getIdentifier(), new Message(MessageCode.M00025,
				"Se presentó un error técnico al intentar verificar si existe un servicio con el nombre: {1}..."));
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
