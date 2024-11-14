package co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.GetServiceInteractor;
import co.edu.uco.bodyhealty.servicios.application.primaryports.mapper.servicio.ServicioDTOmapper;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.consultar.GetService;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.ApplicationBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Service
public class GetServiceInteractorImpl implements GetServiceInteractor {
    private GetService getService;

    public GetServiceInteractorImpl(final GetService getService) {
        this.getService = getService;
    }

    @Override
    public ServicioDTO executeById(UUID id) {
        try {
            ServicioDomain domain = ServicioDomain.buildForQuery(id);
            ServicioDomain resultado = getService.executeById(domain);
            System.out.println("el resultado es:" + resultado);
            return ServicioDTOmapper.INSTANCE.toDTO(resultado);
        } catch (RuleBodyHealtyException ex) {
            throw ex;
        } catch (Exception ex) {
            final String userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00038, id.toString());
            throw ApplicationBodyHealtyException.create(userMessage, userMessage, ex);
        }
    }

    @Override
    public List<ServicioDTO> executeByFilter(ServicioDTO filtro) {
        try {
            ServicioDomain domain = ServicioDTOmapper.INSTANCE.toDomainForFilter(filtro);
            List<ServicioDomain> resultados = getService.executeByFilter(domain);
            return resultados.stream()
                    .map(ServicioDTOmapper.INSTANCE::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            final String userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00039);
            throw ApplicationBodyHealtyException.create(userMessage, userMessage, ex);
        }
    }
}
