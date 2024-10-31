package co.edu.uco.ucobet.generales.application.usecase.city;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.RulesValidator;

@Service
public interface RegisterNewCityStateRulesValidator extends RulesValidator<UUID> {

}
