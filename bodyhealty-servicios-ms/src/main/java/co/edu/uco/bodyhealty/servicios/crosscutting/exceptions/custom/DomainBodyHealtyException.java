package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.BodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.Layer;

public class DomainBodyHealtyException extends BodyHealtyException {

	private static final long serialVersionUID = 1L;

	public DomainBodyHealtyException(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		super(userMessage, TechnicalMessage, rootException, Layer.DOMAIN);
	}

	public static final DomainBodyHealtyException create(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		return new DomainBodyHealtyException(userMessage, TechnicalMessage, rootException);
	}

	public static final DomainBodyHealtyException create(final String userMessage) {
		return new DomainBodyHealtyException(userMessage, userMessage, new Exception());
	}

	public static final DomainBodyHealtyException create(final String userMessage, final String technicalMessage) {
		return new DomainBodyHealtyException(userMessage, technicalMessage, new Exception());
	}

}
