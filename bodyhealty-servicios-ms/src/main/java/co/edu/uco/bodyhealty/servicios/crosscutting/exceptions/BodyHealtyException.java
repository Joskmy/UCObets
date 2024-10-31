package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions;

import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.Layer;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;

public class BodyHealtyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String userMessage;
	private Layer layer;

	public BodyHealtyException(final String userMessage, final String TechnicalMessage, final Exception rootException,
			Layer layer) {
		super(ObjectHelper.getDefault(TechnicalMessage, TextHelper.applyTrim(userMessage)),
				ObjectHelper.getDefault(rootException, new Exception()));
		setUserMessage(userMessage);
		setLayer(layer);
	}

	public String getUserMessage() {
		return userMessage;
	}

	private void setUserMessage(final String userMessage) {
		this.userMessage = TextHelper.applyTrim(userMessage);
	}

	public Layer getLayer() {
		return layer;
	}

	private void setLayer(final Layer layer) {
		this.layer = ObjectHelper.getDefault(layer, Layer.SERVICIO);
	}

}
