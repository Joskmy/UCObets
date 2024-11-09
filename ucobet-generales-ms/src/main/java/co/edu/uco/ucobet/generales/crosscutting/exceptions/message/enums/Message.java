package co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums;


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

	private final void setContent(final String content) {
		this.content = content;
	}

	private final MessageCode getCode() {
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
