package co.edu.uco.bodyhealty.servicios.application.secondaryports.mapper.servicio;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.entity.ServicioEntity;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

public interface ServicioEntityMapper {
	ServicioDomain toDomain(ServicioEntity servicioEntity);
	ServicioEntity toEntity(ServicioDomain servicioDomain);
}
