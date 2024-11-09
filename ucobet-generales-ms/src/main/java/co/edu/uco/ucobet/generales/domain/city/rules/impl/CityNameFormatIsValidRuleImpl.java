package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;

@Service
public class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule {

	@Override
	public void validate(String data) {

		if (!data.matches("^[a-zA-ZñÑáéíóúüÁÉÍÓÚ ]+$")) {
			throw CityNameFormatIsNotValidException.forInvalidFormat();
		}
	}

}
