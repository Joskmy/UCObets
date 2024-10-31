package co.edu.uco.bodyhealty.servicios.domain;

import java.util.UUID;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.UUIDHelper;

public class Domain {
	private UUID id;

	protected Domain(final UUID id) {
		setId(id);
	}

	public final UUID getId() {
		return id;
	}

	private final void setId(final UUID id) {
		this.id = id;
	}
	
	public void generateId() {
		this.id = UUIDHelper.generate();
	}

}
