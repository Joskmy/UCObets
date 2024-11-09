package co.edu.uco.ucobet.generales.domain.state;

import java.util.UUID;

import co.edu.uco.ucobet.generales.domain.Domain;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;

public final class StateDomain extends Domain {
	private String name;
	private CountryDomain country;

	public StateDomain(final UUID id, final String name, final CountryDomain country) {
		super(id);
		setName(name);
		setCountry(country);
		// Agrega un log para verificar los valores
	    System.out.println("StateDomain creado -> id: " + id + ", name: " + name + ", country: " + country);
	}

	public final String getName() {
		return name;
	}

	private final void setName(final String name) {
		this.name = name;
	}

	public final CountryDomain getCountry() {
		return country;
	}

	private final void setCountry(final CountryDomain country) {
		this.country = country;
	}

	@Override
	public String toString() {
	    return "StateDomain{" +
	            "id=" + getId() + 
	            ", name='" + name + '\'' +
	            ", country=" + (country != null ? country.getName() : "null") +
	            '}';
	}
}
