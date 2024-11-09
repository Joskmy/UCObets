package co.edu.uco.ucobet.generales.domain.city.rules.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityStateDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityStateDoesExistsRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;


@Service
public final class CityStateDoesExistsRuleImpl implements CityStateDoesExistsRule {

	private StateRepository stateRepository;

	public CityStateDoesExistsRuleImpl(final StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}

	@Override
	public void validate(final StateDomain state) {
		if (!stateRepository.existsById(state.getId()))
			throw CityStateDoesNotExistsException.create();
	}
}
