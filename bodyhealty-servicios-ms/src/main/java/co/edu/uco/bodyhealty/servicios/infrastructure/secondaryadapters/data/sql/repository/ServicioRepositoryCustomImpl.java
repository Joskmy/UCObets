package co.edu.uco.bodyhealty.servicios.infrastructure.secondaryadapters.data.sql.repository;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.repository.ServicioRepositoryCustom;
import jakarta.persistence.EntityManager;

public class ServicioRepositoryCustomImpl implements ServicioRepositoryCustom {

	private EntityManager entityManager;

	public ServicioRepositoryCustomImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
