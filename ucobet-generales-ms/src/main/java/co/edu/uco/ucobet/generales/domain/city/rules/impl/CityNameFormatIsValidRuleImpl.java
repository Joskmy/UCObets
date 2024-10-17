package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;

public class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule {

	@Override
    public void validate(String data) {
	    if (data.length() < 50) {
	        throw CityNameFormatIsNotValidException.forShortName(); 
	    }
    }

}
