package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.BodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.Layer;

public class EntityBodyHealtyException extends BodyHealtyException {

	private static final long serialVersionUID = 1L;

	public EntityBodyHealtyException(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		super(userMessage, TechnicalMessage, rootException, Layer.ENTITY);
	}

	public static final EntityBodyHealtyException create(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		return new EntityBodyHealtyException(userMessage, TechnicalMessage, rootException);
	}

	public static final EntityBodyHealtyException create(final String userMessage) {
		return new EntityBodyHealtyException(userMessage, userMessage, new Exception());
	}

	public static final EntityBodyHealtyException create(final String userMessage, final String technicalMessage) {
		return new EntityBodyHealtyException(userMessage, technicalMessage, new Exception());
	}

}
