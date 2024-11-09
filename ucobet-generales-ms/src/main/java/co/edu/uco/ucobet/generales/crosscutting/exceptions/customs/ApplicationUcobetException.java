package co.edu.uco.ucobet.generales.crosscutting.exceptions.customs;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.UcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.ApplicationUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public class ApplicationUcobetException extends UcobetException {

	private static final long serialVersionUID = 1L;
	public ApplicationUcobetException(final String userMessage, final String TechnicalMessage, final Exception rootException) {
		super(userMessage, TechnicalMessage, rootException, Layer.APPLICATION);
	}

	public static final ApplicationUcobetException create(final String userMessage, final String TechnicalMessage,
			final Exception rootException) {
		return new ApplicationUcobetException(userMessage, TechnicalMessage, rootException);
	}

	public static final ApplicationUcobetException create(final String userMessage) {
		return new ApplicationUcobetException(userMessage, userMessage, new Exception());
	}

	public static final ApplicationUcobetException create(final String userMessage, final String technicalMessage) {
		return new ApplicationUcobetException(userMessage, technicalMessage, new Exception());
	}
}
