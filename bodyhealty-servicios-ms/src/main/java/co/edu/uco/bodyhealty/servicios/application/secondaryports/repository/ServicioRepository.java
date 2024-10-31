package co.edu.uco.bodyhealty.servicios.application.secondaryports.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.entity.ServicioEntity;

public interface ServicioRepository extends JpaRepository<ServicioEntity, UUID>, ServicioRepositoryCustom{

}
