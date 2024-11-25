package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghtIsValidRule;


@Service

public final class RegisterNewCityNameRulesValidatorImp implements RegisterNewCityNameRulesValidator {

	private CityNameFormatIsValidRule cityNameFormatIsValidRule;
	private CityNameIsNotNullRule cityNameIsNotNullRule;
	private CityNameIsNotEmptyRule cityNameIsNotEmptyRule;
	private CityNameForStateDoesNotExistRule cityNameForStateDoesNotExistRule;
	private CityNameLenghtIsValidRule cityNameLenghtIsValidRule;

	
	
	public RegisterNewCityNameRulesValidatorImp(final CityNameFormatIsValidRule cityNameFormatIsValidRule,
			final CityNameIsNotNullRule cityNameIsNotNullRule, final CityNameIsNotEmptyRule cityNameIsNotEmptyRule,
			final CityNameForStateDoesNotExistRule cityNameForStateDoesNotExistRule,
			final CityNameLenghtIsValidRule cityNameLenghtIsValidRule) {
		this.cityNameFormatIsValidRule = cityNameFormatIsValidRule;
		this.cityNameIsNotNullRule = cityNameIsNotNullRule;
		this.cityNameIsNotEmptyRule = cityNameIsNotEmptyRule;
		this.cityNameForStateDoesNotExistRule = cityNameForStateDoesNotExistRule;
		this.cityNameLenghtIsValidRule = cityNameLenghtIsValidRule;
	}



	@Override
	public void validate(final CityDomain data) {
		cityNameFormatIsValidRule.validate(data.getName());
		cityNameIsNotNullRule.validate(data.getName());
		cityNameIsNotEmptyRule.validate(data.getName());
		cityNameLenghtIsValidRule.validate(data.getName());
		cityNameForStateDoesNotExistRule.validate(data);
	}

}
