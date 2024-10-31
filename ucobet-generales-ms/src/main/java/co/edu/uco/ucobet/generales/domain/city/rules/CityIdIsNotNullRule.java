package co.edu.uco.ucobet.generales.domain.city.rules;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.domain.DomainRule;

@Service

public interface CityIdIsNotNullRule extends DomainRule<UUID> {

}
