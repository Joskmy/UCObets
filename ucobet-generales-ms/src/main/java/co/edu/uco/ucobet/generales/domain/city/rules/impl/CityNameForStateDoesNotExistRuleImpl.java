package co.edu.uco.ucobet.generales.domain.city.rules.impl;


/*
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.city.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameForStateDoesExistException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistRule;

@Service
public class CityNameForStateDoesNotExistRuleImpl implements CityNameForStateDoesNotExistRule {

    private final CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;

    public CityNameForStateDoesNotExistRuleImpl(final CityRepository cityRepository, 
                                               final CityEntityMapper cityEntityMapper) {
        this.cityRepository = cityRepository;
        this.cityEntityMapper = cityEntityMapper;
    }

    @Override
    public void validate(final CityDomain city) {
        var cityEntity = cityEntityMapper.domainToEntity(city);
        
        boolean exists = cityRepository.existsByNameAndState(
            cityEntity.getName(), 
            cityEntity.getState()
        );
        
        if (exists) {
            throw CityNameForStateDoesExistException.create(
                city.getName(),
                city.getState().getId()
            );
        }
    }
}
*/