package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.BodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.Layer;

public class UsecaseBodyHealtyException extends BodyHealtyException {

	private static final long serialVersionUID = 1L;

	public UsecaseBodyHealtyException(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		super(userMessage, TechnicalMessage, rootException, Layer.USECASE);
	}

	public static final UsecaseBodyHealtyException create(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		return new UsecaseBodyHealtyException(userMessage, TechnicalMessage, rootException);
	}

	public static final UsecaseBodyHealtyException create(final String userMessage) {
		return new UsecaseBodyHealtyException(userMessage, userMessage, new Exception());
	}

	public static final UsecaseBodyHealtyException create(final String userMessage, final String technicalMessage) {
		return new UsecaseBodyHealtyException(userMessage, technicalMessage, new Exception());
	}

}
