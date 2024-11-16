package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.Message;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.ObjectHelper;

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
				"El identificador del mensaje ${1} que se intentó obtener, no está en el catálogo de mensajes base..."));
		messages.put(MessageCode.M00004.getIdentifier(), new Message(MessageCode.M00004,
				"El mensaje con identificador ${1} que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
		messages.put(MessageCode.M00005.getIdentifier(), new Message(MessageCode.M00005,
				"El mensaje con identificador ${1} que se intentó obtener, no está configurado para residir en el catálogo de mensajes externo..."));
		messages.put(MessageCode.M00006.getIdentifier(), new Message(MessageCode.M00006,
				"El identificador del mensaje ${1} que se intentó obtener, no está en el catálogo de mensajes externo..."));
		messages.put(MessageCode.M00007.getIdentifier(), new Message(MessageCode.M00007,
				"El servicio: ${1}, se ha registrado correctamente en el sistema..."));
		messages.put(MessageCode.M00008.getIdentifier(), new Message(MessageCode.M00008,
				"La descripciòn del servicio no puede contener más de 500 carácteres..."));
		messages.put(MessageCode.M00009.getIdentifier(),
				new Message(MessageCode.M00009, "La duración del servicio debe ser múltiplo de 15, ejemplo (15, 30, 45....)..."));
		messages.put(MessageCode.M00010.getIdentifier(),
				new Message(MessageCode.M00010, "La duración del servicio no puede estar vacia..."));
		messages.put(MessageCode.M00011.getIdentifier(),
				new Message(MessageCode.M00011, "La descripción del servicio no puede estar vacia..."));
		messages.put(MessageCode.M00012.getIdentifier(), new Message(MessageCode.M00012,
				"La duración del servicio no puede durar menos de 15 minutos, ni más de 300(5 horas) minutos..."));
		messages.put(MessageCode.M00013.getIdentifier(),
				new Message(MessageCode.M00013, "Ha ocurrido un error inesperado en el sistema intentado registrar el servicio ${1}..."));
		messages.put(MessageCode.M00014.getIdentifier(), new Message(MessageCode.M00014,
				"En el proceso de mappeo de DTO a Dominio ha ocurrido un error intentado registrar el servicio ${1}..."));
		messages.put(MessageCode.M00015.getIdentifier(),
				new Message(MessageCode.M00015, "El servicio con el ID ${1} no existe en el sistema..."));
		messages.put(MessageCode.M00016.getIdentifier(),
				new Message(MessageCode.M00016, "El servicio con el ID ${1} existe en el sistema..."));
		messages.put(MessageCode.M00017.getIdentifier(),
				new Message(MessageCode.M00017, "El ID del servicio no puede ser nulo..."));
		messages.put(MessageCode.M00018.getIdentifier(),
				new Message(MessageCode.M00018, "El servicio con ID ${1} está siendo utilizado..."));
		messages.put(MessageCode.M00019.getIdentifier(),
				new Message(MessageCode.M00019, "Ha ocurrido un error buscando el servicio con id ${1} en el sistema..."));
		messages.put(MessageCode.M00020.getIdentifier(), new Message(MessageCode.M00020,
				"Ha ocurrido un error inesperado cuando se estaba buscando el servicio en la base de datos en la parte de  ServicioRepositoryCustomImpl"));
		messages.put(MessageCode.M00021.getIdentifier(), new Message(MessageCode.M00021,
				"El ID ${1] No tiene el formato válido (Formato para UUID)"));
		messages.put(MessageCode.M00026.getIdentifier(), new Message(MessageCode.M00026,
				"El nombre del servicio no puede estar vacio..."));
		messages.put(MessageCode.M00027.getIdentifier(), new Message(MessageCode.M00027,
				"El nombre del servicio ${1} ya existe en el sistema"));
		messages.put(MessageCode.M00028.getIdentifier(), new Message(MessageCode.M00028,
				"El nombre del servicio no tiene un formato válido. Solo se permiten letras (con o sin tilde), y espacios."));
		messages.put(MessageCode.M00029.getIdentifier(), new Message(MessageCode.M00029,
				"El nombre del servicio no puede tener más de 50 carácteres"));
		messages.put(MessageCode.M00030.getIdentifier(), new Message(MessageCode.M00030,
				"Ha ocurrido un error inesperado en el sistema tratando de modificar el servicio..."));
		messages.put(MessageCode.M00031.getIdentifier(), new Message(MessageCode.M00031,
				"Ha ocurrido un error durante el mappeo o algo inesperado en la capa del Interactor..."));
		messages.put(MessageCode.M00032.getIdentifier(), new Message(MessageCode.M00031,
				"Se ha modificado con éxito el Servicio con ID ${1} en el sistema..."));
		messages.put(MessageCode.M00033.getIdentifier(), new Message(MessageCode.M00031,
				"Se ha modificado con éxito el Servicio con nombre ${1} en el sistema..."));
		messages.put(MessageCode.M00034.getIdentifier(), new Message(MessageCode.M00034,
				"Se ha eliminado el servicio con id  ${1} del sistema..."));
		messages.put(MessageCode.M00035.getIdentifier(), new Message(MessageCode.M00035,
				"Ha ocurrido un error inesperado durante la eliminación del servicio con id ${1}..."));
		messages.put(MessageCode.M00036.getIdentifier(), new Message(MessageCode.M00036,
				"La solicitud de datos se realizò de manera correcta..."));
		messages.put(MessageCode.M00037.getIdentifier(), new Message(MessageCode.M00037,
				"Ha ocurrido un error inesperado durante la solicitud de datos..."));
		messages.put(MessageCode.M00038.getIdentifier(), new Message(MessageCode.M00038,
				"Ha ocurrido un error durante la consulta de los datos con id ${1}..."));
		messages.put(MessageCode.M00039.getIdentifier(), new Message(MessageCode.M00039,
				"Ha ocurrido un error durante la consulta de los datos con el filtro indicado..."));
		messages.put(MessageCode.M00040.getIdentifier(), new Message(MessageCode.M00040,
				"No se encontraron datos en la base de datos aplicando el filtro..."));
	
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
			var techMessage = getMessageContent(MessageCode.M00004, code.getIdentifier());
			throw RuleBodyHealtyException.create(userMessage, techMessage);
		}

		if (!messages.containsKey(code.getIdentifier())) {
			var userMessage = getMessageContent(MessageCode.M00002);
			var techMessage = getMessageContent(MessageCode.M00003, code.getIdentifier());
			throw RuleBodyHealtyException.create(userMessage, techMessage);
		}
		
	    Message originalMessage = messages.get(code.getIdentifier());
	    Message newMessage = new Message(originalMessage.getCode(), originalMessage.getContent());

		if (parameters != null && parameters.length > 0) {
			String content = newMessage.getContent();
			for (int i = 0; i < parameters.length; i++) {
				content = content.replace("${" + (i + 1) + "}", parameters[i]);
			}
			newMessage.setContent(content);
		}

		return newMessage;
	}
}