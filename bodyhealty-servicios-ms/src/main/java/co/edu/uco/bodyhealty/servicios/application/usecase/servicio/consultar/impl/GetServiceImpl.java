package co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.entity.ServicioEntity;
import co.edu.uco.bodyhealty.servicios.application.secondaryports.mapper.servicio.ServicioEntityMapper;
import co.edu.uco.bodyhealty.servicios.application.secondaryports.repository.ServicioRepository;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.GetService;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.GetServiceIdRulesValidator;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.GetServiceRulesValidator;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Service
public class GetServiceImpl implements GetService {
    private ServicioRepository servicioRepository;
    private GetServiceRulesValidator getServiceRulesValidator;
    private GetServiceIdRulesValidator getServiceIdRulesValidator;
    
    

   
	public GetServiceImpl(final ServicioRepository servicioRepository, final GetServiceRulesValidator getServiceRulesValidator,
			final GetServiceIdRulesValidator getServiceIdRulesValidator) {
		this.servicioRepository = servicioRepository;
		this.getServiceRulesValidator = getServiceRulesValidator;
		this.getServiceIdRulesValidator = getServiceIdRulesValidator;
	}

	@Override
    public ServicioDomain executeById(ServicioDomain domain) {
		getServiceIdRulesValidator.validate(domain);
        Optional<ServicioEntity> resultado = servicioRepository.findById(domain.getId());
        return ServicioEntityMapper.INSTANCE.toDomain(resultado.get());
    }

	@Override
    public List<ServicioDomain> executeByFilter(ServicioDomain domain) {
		getServiceRulesValidator.validate(domain);
        ServicioEntity filter = ServicioEntityMapper.INSTANCE.toEntity(domain);
        System.out.println("Entrará en los custom buscando" + filter);
        List<ServicioEntity> resultados = servicioRepository.findByFilter(filter);
        System.out.println("RESULTADO: " + resultados);
        if (resultados.isEmpty()) {
            return Collections.emptyList();
        }
        
        return resultados.stream()
                .map(ServicioEntityMapper.INSTANCE::toDomain)
                .collect(Collectors.toList());
    }
}