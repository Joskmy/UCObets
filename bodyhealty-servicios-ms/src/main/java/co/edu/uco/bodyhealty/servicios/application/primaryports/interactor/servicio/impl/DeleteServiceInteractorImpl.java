package co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.application.primaryports.interactor.servicio.DeleteServiceInteractor;
import co.edu.uco.bodyhealty.servicios.application.primaryports.mapper.servicio.ServicioDTOmapper;
import co.edu.uco.bodyhealty.servicios.application.usecase.servicio.eliminar.DeleteService;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.ApplicationBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RuleBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.servicios.domain.servicio.ServicioDomain;

@Service
public class DeleteServiceInteractorImpl implements DeleteServiceInteractor{

	private DeleteService deleteService;

    public DeleteServiceInteractorImpl(final DeleteService deleteService) {
        this.deleteService = deleteService;
    }

    @Override
    public void execute(final UUID id) {
        try {
        	ServicioDomain servicioDomain = ServicioDTOmapper.INSTANCE.toDomainOnlyId(id);
            deleteService.execute(servicioDomain);
        } catch (RuleBodyHealtyException ex) {
            throw ex;
        } catch (Exception ex) {
            final String userMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00035, id.toString());
            final String technicalMessage = MessageCatalogStrategy.getContentMessage(MessageCode.M00035, id.toString());
            throw ApplicationBodyHealtyException.create(userMessage, technicalMessage, ex);
        }
    }
}
