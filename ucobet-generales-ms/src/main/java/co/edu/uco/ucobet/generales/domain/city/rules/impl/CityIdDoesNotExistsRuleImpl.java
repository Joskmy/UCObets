package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistsRule;

@Service
public class CityIdDoesNotExistsRuleImpl implements CityIdDoesNotExistsRule {

	private final CityRepository cityRepository;
    
    public CityIdDoesNotExistsRuleImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void validate(final UUID data) {
        if (cityRepository.existsById(data)) {
            throw CityIdDoesExistsException.create();
        }
    }

}
