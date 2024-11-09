package co.edu.uco.ucobet.generales.application.primaryports.dto;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

public class CountryDTO {
	private UUID id;
	private String name;

	public CountryDTO() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public CountryDTO(UUID id, String name) {
		setId(id);
		setName(name);
	}

	public static CountryDTO create () {
		return new CountryDTO();

	}
	public static CountryDTO create(UUID id, String name) {
		return new CountryDTO(id, name);

	}
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.applyTrim(name);
	}
}
