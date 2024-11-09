package co.edu.uco.ucobet.generales.crosscutting.exceptions.customs;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.UcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.CrosscuttingUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public class CrosscuttingUcobetException extends UcobetException {
	private static final long serialVersionUID = 1L;

	public CrosscuttingUcobetException(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		super(userMessage, TechnicalMessage, rootException, Layer.CROSSCUTING);
	}

	public static final CrosscuttingUcobetException create(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		return new CrosscuttingUcobetException(userMessage, TechnicalMessage, rootException);
	}

	public static final CrosscuttingUcobetException create(final String userMessage) {
		return new CrosscuttingUcobetException(userMessage, userMessage, new Exception());
	}

	public static final CrosscuttingUcobetException create(final String userMessage, final String technicalMessage) {
		return new CrosscuttingUcobetException(userMessage, technicalMessage, new Exception());
	}
}
