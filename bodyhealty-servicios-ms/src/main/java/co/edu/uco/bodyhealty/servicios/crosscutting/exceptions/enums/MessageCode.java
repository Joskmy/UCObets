package co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums;

import static co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper.UNDERLINE;
import static co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper.concatenate;


public enum MessageCode {
	M00001(MessageType.TECHNICAL, MessageCategory.ERROR, "00001", true),
	M00002(MessageType.USER, MessageCategory.ERROR, "00002", true),
	M00003(MessageType.TECHNICAL, MessageCategory.ERROR, "00003", true),
	M00004(MessageType.TECHNICAL, MessageCategory.ERROR, "00004", true),
	M00005(MessageType.TECHNICAL, MessageCategory.ERROR, "00005", true),
	M00006(MessageType.TECHNICAL, MessageCategory.ERROR, "00006", true),
	M00007(MessageType.USER, MessageCategory.SUCCESS, "00007", true),
	M00008(MessageType.USER, MessageCategory.ERROR, "00008", true),
	M00009(MessageType.USER, MessageCategory.ERROR, "00009", true),
	M00010(MessageType.USER, MessageCategory.ERROR, "00010", true),
	M00011(MessageType.USER, MessageCategory.ERROR, "00011", true),
	M00012(MessageType.USER, MessageCategory.ERROR, "00012", true),
	M00013(MessageType.USER, MessageCategory.ERROR, "00013", true),
	M00014(MessageType.TECHNICAL, MessageCategory.ERROR, "00014", true),
	M00015(MessageType.USER, MessageCategory.ERROR, "00015", true),
	M00016(MessageType.USER, MessageCategory.ERROR, "00016", true),
	M00017(MessageType.USER, MessageCategory.ERROR, "00017", true),
	M00018(MessageType.USER, MessageCategory.ERROR, "00018", true),
	M00019(MessageType.USER, MessageCategory.ERROR, "00019", true),
	M00020(MessageType.USER, MessageCategory.ERROR, "00020", true),
	M00021(MessageType.USER, MessageCategory.ERROR, "00021", true),
	M00022(MessageType.USER, MessageCategory.ERROR, "00022", false),
	M00023(MessageType.TECHNICAL, MessageCategory.ERROR, "00023", false),
	M00024(MessageType.USER, MessageCategory.ERROR, "00024", false),
	M00025(MessageType.USER, MessageCategory.ERROR, "00025", false),
	M00026(MessageType.USER, MessageCategory.ERROR, "00026", true),
	M00027(MessageType.USER, MessageCategory.ERROR, "00027", true),
	M00028(MessageType.USER, MessageCategory.ERROR, "00028", true),
	M00029(MessageType.USER, MessageCategory.ERROR, "00029", true),
	M00030(MessageType.USER, MessageCategory.ERROR, "00030", true),
	M00031(MessageType.TECHNICAL, MessageCategory.ERROR, "00031", true),
	M00032(MessageType.USER, MessageCategory.SUCCESS, "00032", true),
	M00033(MessageType.USER, MessageCategory.SUCCESS, "00033", true);
	

	private MessageType type;
	private MessageCategory category;
	private String code;
	private boolean base;

	private MessageCode(final MessageType type, final MessageCategory category, final String code, final boolean base) {
		setType(type);
		setCategory(category);
		setCode(code);
		setBase(base);
	}

	public final MessageType getType() {
		return type;
	}

	public final MessageCategory getCategory() {
		return category;
	}

	public final String getCode() {
		return code;
	}

	public final boolean isBase() {
		return base;
	}

	private final void setType(final MessageType type) {
		this.type = type;
	}

	private final void setCategory(final MessageCategory category) {
		this.category = category;
	}

	private final void setCode(final String code) {
		this.code = code;
	}

	private final void setBase(final boolean base) {
		this.base = base;
	}

	public final String getIdentifier() {
		return concatenate(getType().name(), UNDERLINE, getCategory().name(), UNDERLINE, getCode());
	}

}