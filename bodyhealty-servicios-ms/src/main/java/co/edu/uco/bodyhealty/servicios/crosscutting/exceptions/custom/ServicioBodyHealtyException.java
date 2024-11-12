package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.BodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.Layer;

public class ServicioBodyHealtyException extends BodyHealtyException {

	private static final long serialVersionUID = 1L;

	public ServicioBodyHealtyException(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		super(userMessage, TechnicalMessage, rootException, Layer.SERVICIO);
	}

	public static final ServicioBodyHealtyException create(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		return new ServicioBodyHealtyException(userMessage, TechnicalMessage, rootException);
	}

	public static final ServicioBodyHealtyException create(final String userMessage) {
		return new ServicioBodyHealtyException(userMessage, userMessage, new Exception());
	}

	public static final ServicioBodyHealtyException create(final String userMessage, final String technicalMessage) {
		return new ServicioBodyHealtyException(userMessage, technicalMessage, new Exception());
	}

}
