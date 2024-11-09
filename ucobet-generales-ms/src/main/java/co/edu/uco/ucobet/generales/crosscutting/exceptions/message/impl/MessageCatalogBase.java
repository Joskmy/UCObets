package co.edu.uco.ucobet.generales.crosscutting.exceptions.message.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.CrosscuttingUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.MessageCatalog;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.Message;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogBase implements MessageCatalog {
	private final Map<String, Message> messages = new HashMap<>();

	@Override
	public final void initialize() {
		messages.clear();
		messages.put(MessageCode.M00001.getIdentifier(), new Message(MessageCode.M00001,
				"El código del mensaje que quiere obtener del catálogo mensajes llegó nulo..."));
		messages.put(MessageCode.M00002.getIdentifier(), new Message(MessageCode.M00002,
				"Se ha presentado un problema tratando de llevar a cabo la operación deseada..."));
		messages.put(MessageCode.M00003.getIdentifier(), new Message(MessageCode.M00003,
				"El identificador del mensaje \\\"${1}\\\" que se intentó obtener, no está en el catálogo de mensajes base..."));
		messages.put(MessageCode.M00004.getIdentifier(), new Message(MessageCode.M00004,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
		messages.put(MessageCode.M00005.getIdentifier(), new Message(MessageCode.M00005,
				"El mensaje con identificador \\\"${1}\\\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes externo..."));
		messages.put(MessageCode.M00006.getIdentifier(), new Message(MessageCode.M00006,
				"El identificador del mensaje \\\"${1}\\\" que se intentó obtener, no está en el catálogo de mensajes externo..."));
		messages.put(MessageCode.M00007.getIdentifier(), new Message(MessageCode.M00007,
				"No existe la ciudad con el id indicado..."));
		messages.put(MessageCode.M00008.getIdentifier(), new Message(MessageCode.M00008,
				"Se ha presentado un problema  INESPERADO ME FALTA Entender como cambio este mensaje..."));
		messages.put(MessageCode.M00009.getIdentifier(), new Message(MessageCode.M00009,
				"Ya existe una ciudad con el ID proporcionado..."));
		messages.put(MessageCode.M00010.getIdentifier(), new Message(MessageCode.M00010,
				"El id de la ciudad no puede ser nulo..."));
		messages.put(MessageCode.M00011.getIdentifier(), new Message(MessageCode.M00011,
				"Hubo un problema al verificar si la ciudad ya está en uso..."));
		messages.put(MessageCode.M00012.getIdentifier(), new Message(MessageCode.M00012,
				"Error ejecutando consulta para verificar si la ciudad está siendo utilizada..."));
		messages.put(MessageCode.M00013.getIdentifier(), new Message(MessageCode.M00013,
				"La ciudad ya está en uso..."));
		messages.put(MessageCode.M00014.getIdentifier(), new Message(MessageCode.M00014,
				"El nombre de la ciudad solo puede contener letras y espacios(con y sin tílde..."));
		messages.put(MessageCode.M00015.getIdentifier(), new Message(MessageCode.M00015,
				"La ciudad  que intentas registrar ya existe para ese estado..."));
		messages.put(MessageCode.M00016.getIdentifier(), new Message(MessageCode.M00016,
				"El nombre de la ciudad no puede estar vacio..."));
		messages.put(MessageCode.M00017.getIdentifier(), new Message(MessageCode.M00017,
				"El nombre de la ciudad no puede ser nulo..."));
		messages.put(MessageCode.M00018.getIdentifier(), new Message(MessageCode.M00018,
				"El nombre de la ciudad debe tener al menos 255 caracteres..."));
		messages.put(MessageCode.M00019.getIdentifier(), new Message(MessageCode.M00019,
				"Ya existe un estado con el ID proporcionado..."));
		

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
			var techMessage = getMessageContent(MessageCode.M00004, code.getIdentifier());
			throw CrosscuttingUcobetException.create(userMessage, techMessage);
		}

		if (!messages.containsKey(code.getIdentifier())) {
			var userMessage = getMessageContent(MessageCode.M00002);
			var techMessage = getMessageContent(MessageCode.M00003, code.getIdentifier());
			throw CrosscuttingUcobetException.create(userMessage, techMessage);
		}

		return messages.get(code.getIdentifier());
	}
}
