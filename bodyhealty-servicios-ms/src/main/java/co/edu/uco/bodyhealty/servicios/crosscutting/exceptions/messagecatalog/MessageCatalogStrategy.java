package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.Message;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.impl.MessageCatalogBase;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.impl.MessageCatalogExternalService;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogStrategy {
	private static final MessageCatalog base = new MessageCatalogBase();
	private static final MessageCatalog externalService = new MessageCatalogExternalService();

	static {
		initialize();
	}

	private MessageCatalogStrategy() {
		super();
	}

	public static void initialize() {
		base.initialize();
		externalService.initialize();
	}

	private static final MessageCatalog getStrategy(final boolean isBase) {
		return isBase ? base : externalService;
	}

	public static final Message getMessage(final MessageCode codigo, final String... parametros) {

		if (ObjectHelper.isNull(codigo)) {
			var mensajeUsuario = MessageCatalogStrategy.getContentMessage(MessageCode.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContentMessage(MessageCode.M00001);
			throw RuleBodyHealtyException.create(mensajeUsuario, mensajeTecnico);
		}

		return getStrategy(codigo.isBase()).getMessage(codigo, parametros);
	}

	public static final String getContentMessage(final MessageCode codigo, final String... parametros) {
		return getMessage(codigo, parametros).getContent();
	}

}