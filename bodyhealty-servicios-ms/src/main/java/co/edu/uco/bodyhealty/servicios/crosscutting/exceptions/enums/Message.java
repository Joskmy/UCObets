package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums;

public final class Message {
	private MessageCode code;
	private String content;

	public Message(final MessageCode code, final String content) {
		setCode(code);
		setContent(content);
	}

	public final boolean isBase() {
		return getCode().isBase();
	}

	private final void setCode(final MessageCode code) {
		this.code = code;
	}

	public final void setContent(final String content) {
		this.content = content;
	}

	public final MessageCode getCode() {
		return code;
	}

	public final MessageCategory getCategory() {
		return getCode().getCategory();
	}

	public final MessageType getType() {
		return getCode().getType();
	}

	public final String getContent() {
		return content;
	}

	public final String getIdentifier() {
		return getCode().getIdentifier();
	}

}