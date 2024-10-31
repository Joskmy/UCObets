package co.edu.uco.bodyhealty.servicios.application.primaryports.mapper.servicio;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

public interface ServicioDTOmapper {
	ServicioDomain toDomain(ServicioDTO servicioDTO);

	ServicioDTO toDTO(ServicioDomain servicioDomain);
}
