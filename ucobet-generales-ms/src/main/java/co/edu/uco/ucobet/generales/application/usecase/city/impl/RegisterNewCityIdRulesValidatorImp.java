package co.edu.uco.ucobet.generales.application.usecase.city.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistsRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;


@Service

public final class RegisterNewCityIdRulesValidatorImp implements RegisterNewCityIdRulesValidator {

	private CityIdIsNotNullRule cityIdIsNotNullRule;
	private CityIdDoesNotExistsRule cityIdDoesNotExistsRule;
	
	
	public RegisterNewCityIdRulesValidatorImp(final CityIdDoesNotExistsRule cityIdDoesNotExistsRule, final CityIdIsNotNullRule cityIdIsNotNullRule) {
		this.cityIdDoesNotExistsRule = cityIdDoesNotExistsRule;
		this.cityIdIsNotNullRule = cityIdIsNotNullRule;
	}

	@Override
	public void validate(final CityDomain data) {
		cityIdDoesNotExistsRule.validate(data.getId());
		cityIdIsNotNullRule.validate(data.getId());
	}


}
