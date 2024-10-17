package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;

public class CityNameIsNotNullRuleImpl implements CityNameIsNotNullRule {

	@Override
	public void validate(final String data) {
		if (TextHelper.isEmpty(data)) {
			throw CityNameIsNullException.create();
		}

	}
}
