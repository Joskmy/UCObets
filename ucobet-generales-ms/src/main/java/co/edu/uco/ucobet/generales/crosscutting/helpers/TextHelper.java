package co.edu.uco.ucobet.generales.crosscutting.helpers;

public class TextHelper {

	public static final String EMPTY = "";
	public static final String UNDERLINE = "_";
	
	public static final String EMAIL_RECIPIENT = "jmposadao22@gmail.com";
    public static final String EMAIL_SUBJECT = "Nueva Ciudad Registrada en UCOBet";
    public static final String EMAIL_BODY_PREFIX = "Se ha registrado exitosamente la ciudad: ";
    public static final String EMAIL_BODY_SUFFIX = " en el sistema.";
    
	private TextHelper() {

	}

	public static boolean isNull(final String string) {
		return ObjectHelper.isNull(string);
	}

	public static String getDefault(final String string, final String defaultValue) {
		return ObjectHelper.getDefault(string, defaultValue);
	}

	public static String getDefault(final String string) {
		return getDefault(string, EMPTY);
	}

	public static boolean isEmpty(final String string) {
		return EMPTY.equals(getDefault(string));
	}

	public static boolean isEmptyApplyingTrim(final String string) {
		return isEmpty(applyTrim(string));
	}

	public static String applyTrim(final String string) {
		return getDefault(string).trim();
		
	}
	
	public static final String concatenate(final String... strings) {
	    final var sb = new StringBuilder(EMPTY);

	    if (!ObjectHelper.isNull(strings)) {
	        for (final var string : strings) {
	            sb.append(applyTrim(string));
	        }
	    }

	    return sb.toString();
	}
	
	public static String buildEmailBody(final String cityName) {
        return concatenate(EMAIL_BODY_PREFIX, cityName, EMAIL_BODY_SUFFIX);
    }

}
