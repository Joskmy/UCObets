package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityStateRulesValidator;

import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;


@Service


public final class RegisterNewCityStateRulesValidatorImp implements RegisterNewCityStateRulesValidator {

	private StateDoesExistsRule doesExistsRule;
	private StateIdIsNotNullRule idIsNotNullRule;

	public RegisterNewCityStateRulesValidatorImp(final StateDoesExistsRule doesExistsRule,
			final StateIdIsNotNullRule idIsNotNullRule) {
		this.doesExistsRule = doesExistsRule;
		this.idIsNotNullRule = idIsNotNullRule;
	}

	@Override
	public void validate(final UUID stateId) {

		idIsNotNullRule.validate(stateId);
		doesExistsRule.validate(stateId);

	}

}
