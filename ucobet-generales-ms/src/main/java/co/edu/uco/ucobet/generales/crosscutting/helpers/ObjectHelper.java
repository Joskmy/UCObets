package co.edu.uco.ucobet.generales.crosscutting.helpers;

public  class ObjectHelper {
	private static final ObjectHelper instance = new ObjectHelper();
	
	private ObjectHelper() {

	}
	
	public static final ObjectHelper getObjectHelper() {
		return instance;
	}

	public static <O> boolean isNull(final O object) {
		return object == null;
	}

	public static <O> O getDefault(final O object, final O defaultObject) {
		return isNull(object) ? defaultObject : object;
	}

}
