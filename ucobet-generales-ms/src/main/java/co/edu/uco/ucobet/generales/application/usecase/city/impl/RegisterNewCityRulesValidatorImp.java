package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;


@Service

public final class RegisterNewCityRulesValidatorImp implements RegisterNewCityRulesValidator {

	private RegisterNewCityIdRulesValidator registerNewCityIdRulesValidator;
	private RegisterNewCityNameRulesValidator registerNewCityNameRulesValidator;
	private RegisterNewCityStateRulesValidator regjsCityStateRulesValidator;

	public RegisterNewCityRulesValidatorImp(final RegisterNewCityIdRulesValidator registerNewCityIdRulesValidator,
			final RegisterNewCityNameRulesValidator registerNewCityNameRulesValidator,
			final RegisterNewCityStateRulesValidator regjsCityStateRulesValidator) {
		this.registerNewCityIdRulesValidator = registerNewCityIdRulesValidator;
		this.registerNewCityNameRulesValidator = registerNewCityNameRulesValidator;
		this.regjsCityStateRulesValidator = regjsCityStateRulesValidator;
	}

	@Override
	public void validate(final CityDomain data) {
		registerNewCityIdRulesValidator.validate(data);
		registerNewCityNameRulesValidator.validate(data);
		regjsCityStateRulesValidator.validate(data.getState().getId());

	}

}
