package co.edu.uco.bodyhealty.servicios.application.secondaryports.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.entity.ServicioEntity;

@Repository
public interface ServicioRepositoryCustom {
	boolean isServiceUsed(UUID serviceId);
	List<ServicioEntity> findByFilter(final ServicioEntity filter);
    boolean existsByName(String name);

}
