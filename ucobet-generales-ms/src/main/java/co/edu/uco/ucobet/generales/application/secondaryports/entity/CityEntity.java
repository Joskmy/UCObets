package co.edu.uco.ucobet.generales.application.secondaryports.entity;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "City")

public final class CityEntity {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private StateEntity state;

	CityEntity() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setState(StateEntity.create());
	}

	public CityEntity(final UUID id, final String name, final StateEntity state) {
		setId(id);
		setName(name);
		setState(state);
	}

	public static final CityEntity create() {
		return new CityEntity();
	}

	public static final CityEntity create(final UUID id, final String name, final StateEntity state) {
		return new CityEntity(id, name, state);
	}

	public static final CityEntity create(final UUID id) {
		return new CityEntity(id, TextHelper.EMPTY, StateEntity.create());
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

	public StateEntity getState() {
		return state;
	}

	public void setState(final StateEntity state) {
		this.state = ObjectHelper.getDefault(state, StateEntity.create());
	}

	@Override
	public String toString() {
		return "CityEntity [id=" + id + ", name=" + name + ", state=" + state + "]";
	}
	
	
}
