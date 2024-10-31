package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import java.util.UUID;


import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;

public final class StateDoesExistsRuleImpl implements StateDoesExistsRule {
	
	private StateRepository stateRepository;
	
	
	public StateDoesExistsRuleImpl(final StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}

	@Override
	public void validate(final UUID data) {
		if(!stateRepository.existsById(data)) {
			throw StateDoesNotExistsException.create();
		}
		
	}

}
