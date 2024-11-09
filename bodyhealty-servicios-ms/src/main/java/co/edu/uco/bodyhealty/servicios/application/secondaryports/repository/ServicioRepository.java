package co.edu.uco.bodyhealty.servicios.application.secondaryports.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.entity.ServicioEntity;

@Repository
public interface ServicioRepository extends JpaRepository<ServicioEntity, UUID>, ServicioRepositoryCustom{

}
