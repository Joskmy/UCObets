package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.BodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.Layer;

public class ApplicationBodyHealtyException extends BodyHealtyException {

	private static final long serialVersionUID = 1L;

	public ApplicationBodyHealtyException(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		super(userMessage, TechnicalMessage, rootException, Layer.APPLICATION);
	}

	public static final ApplicationBodyHealtyException create(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		return new ApplicationBodyHealtyException(userMessage, TechnicalMessage, rootException);
	}

	public static final ApplicationBodyHealtyException create(final String userMessage) {
		return new ApplicationBodyHealtyException(userMessage, userMessage, new Exception());
	}

	public static final ApplicationBodyHealtyException create(final String userMessage, final String technicalMessage) {
		return new ApplicationBodyHealtyException(userMessage, technicalMessage, new Exception());
	}

}
