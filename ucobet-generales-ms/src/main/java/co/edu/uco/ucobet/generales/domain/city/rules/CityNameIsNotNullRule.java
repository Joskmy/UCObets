package co.edu.uco.ucobet.generales.domain.city.rules;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.domain.DomainRule;

@Service

public interface CityNameIsNotNullRule extends DomainRule<String> {

}
