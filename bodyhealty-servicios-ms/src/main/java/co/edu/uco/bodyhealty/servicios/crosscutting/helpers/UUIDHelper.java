package co.edu.uco.bodyhealty.servicios.crosscutting.helpers;

import java.util.UUID;
import java.util.regex.Pattern;

public final class UUIDHelper {

	private static final String DEFAULT_UUID_STRING = "00000000-0000-0000-0000-000000000000";
	private static final Pattern UUID_PATTERN = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
	private UUIDHelper() {
		super();
	}

	public static final UUID convertToUUID(final String uuidAsString) {
		return UUID.fromString(uuidAsString);
	}

	public static final UUID getDefault(final UUID value, final UUID defaultValue) {
		return ObjectHelper.getDefault(value, defaultValue);
	}

	public static final String getDefaultAsString() {
		return DEFAULT_UUID_STRING;
	}

	public static final UUID getDefault() {
		return convertToUUID(DEFAULT_UUID_STRING);
	}

	public static final UUID generate() {
		return UUID.randomUUID();
	}

	public static final boolean isDefault(final UUID value) {
		return getDefault(value, getDefault()).equals(getDefault());
	}

	public static final boolean isDefault(final String uuidAsString) {
		return getDefault(convertToUUID(uuidAsString), getDefault()).equals(getDefault());
	}

	public static final boolean isValidUUID(UUID value) {
        return UUID_PATTERN.matcher(value.toString()).matches();
    }
}