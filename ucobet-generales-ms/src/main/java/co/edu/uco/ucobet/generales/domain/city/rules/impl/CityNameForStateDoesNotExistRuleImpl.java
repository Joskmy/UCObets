package co.edu.uco.ucobet.generales.domain.city.rules.impl;



import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistRule;

public  class CityNameForStateDoesNotExistRuleImpl implements CityNameForStateDoesNotExistRule {

	@Override
	public void validate(CityDomain data) {
		// TODO Auto-generated method stub
		
	}
/*
	private CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;


	
	public CityNameForStateDoesNotExistRuleImpl(final CityRepository cityRepository, final CityEntityMapper cityEntityMapper) {
		this.cityRepository = cityRepository;
		this.cityEntityMapper = cityEntityMapper;
	}

	@Override
	public void validate(CityDomain city) {
	    CityEntity cityEntity = cityEntityMapper.toEntity(city);

	    boolean exists = !cityRepository.findByFilter(cityEntity).isEmpty();
        
        if (exists) {
            throw CityNameForStateDoesExistException.create(city.getName(),city.getState().getId());
        }
	}
	*/
}
