package co.edu.uco.bodyhealty.servicios.domain.servicio.rules;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.bodyhealty.servicios.domain.DomainRule;


@Service
public interface ServiceIdIsNotNullRule extends DomainRule<UUID> {

}
