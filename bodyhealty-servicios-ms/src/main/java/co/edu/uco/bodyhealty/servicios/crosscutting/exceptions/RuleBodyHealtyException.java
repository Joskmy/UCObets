package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.Layer;

public class RuleBodyHealtyException extends BodyHealtyException {

	private static final long serialVersionUID = 1L;

	public RuleBodyHealtyException(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		super(userMessage, TechnicalMessage, rootException, Layer.RULE);
	}

	public static final RuleBodyHealtyException create(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		return new RuleBodyHealtyException(userMessage, TechnicalMessage, rootException);
	}

	public static final RuleBodyHealtyException create(final String userMessage) {
		return new RuleBodyHealtyException(userMessage, userMessage, new Exception());
	}

	public static final RuleBodyHealtyException create(final String userMessage, final String technicalMessage) {
		return new RuleBodyHealtyException(userMessage, technicalMessage, new Exception());
	}

}
