package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameLenghtIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghtIsValidRule;

@Service
public class CityNameLenghtIsValidRuleImpl implements CityNameLenghtIsValidRule{
	
	@Override
    public void validate(String data) {
	    if (data.length() > 255) {
	        throw CityNameLenghtIsNotValidException.create(); 
	    }
    }
}
