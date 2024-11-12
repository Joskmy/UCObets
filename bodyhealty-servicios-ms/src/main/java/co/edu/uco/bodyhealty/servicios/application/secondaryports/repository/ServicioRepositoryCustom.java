package co.edu.uco.bodyhealty.servicios.application.secondaryports.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepositoryCustom {
	boolean isServiceUsed(UUID serviceId);

}
