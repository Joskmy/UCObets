package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.Layer;

public class RepositoryBodyHealtyException extends BodyHealtyException {
	private static final long serialVersionUID = 1L;

	public RepositoryBodyHealtyException(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		super(userMessage, TechnicalMessage, rootException, Layer.REPOSITORY);
	}

	public static final RepositoryBodyHealtyException create(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		return new RepositoryBodyHealtyException(userMessage, TechnicalMessage, rootException);
	}

	public static final RepositoryBodyHealtyException create(final String userMessage) {
		return new RepositoryBodyHealtyException(userMessage, userMessage, new Exception());
	}

	public static final RepositoryBodyHealtyException create(final String userMessage, final String technicalMessage) {
		return new RepositoryBodyHealtyException(userMessage, technicalMessage, new Exception());
	}
}
