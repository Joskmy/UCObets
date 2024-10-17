package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameLenghtIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghtIsValidRule;

public class CityNameLenghtIsValidRuleImpl implements CityNameLenghtIsValidRule{
	
	@Override
    public void validate(String data) {
	    if (data.length() < 50) {
	        throw CityNameLenghtIsNotValidException.create(); 
	    }
    }
}
