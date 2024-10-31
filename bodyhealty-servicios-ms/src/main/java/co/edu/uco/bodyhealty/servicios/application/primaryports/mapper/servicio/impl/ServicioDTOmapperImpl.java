package co.edu.uco.bodyhealty.servicios.application.primaryports.mapper.servicio.impl;

import org.modelmapper.ModelMapper;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.application.primaryports.mapper.servicio.ServicioDTOmapper;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

public class ServicioDTOmapperImpl implements ServicioDTOmapper {
private final ModelMapper modelMapper;
	
	public ServicioDTOmapperImpl() {
        this.modelMapper = new ModelMapper();
    }

	@Override
    public ServicioDomain toDomain(ServicioDTO servicioDTO) {
        return modelMapper.map(servicioDTO, ServicioDomain.class);
    }

    @Override
    public ServicioDTO toDTO(ServicioDomain servicoDomain) {
        return modelMapper.map(servicoDomain, ServicioDTO.class);
    }
}
