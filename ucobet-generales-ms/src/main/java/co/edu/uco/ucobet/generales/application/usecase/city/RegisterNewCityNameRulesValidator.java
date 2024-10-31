package co.edu.uco.ucobet.generales.application.usecase.city;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.RulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service
public interface RegisterNewCityNameRulesValidator extends RulesValidator<CityDomain> {

}
