package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameForStateDoesExistException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistRule;

public class CityNameForStateDoesNotExistRuleImpl implements CityNameForStateDoesNotExistRule {

	@Override
	public void validate(CityDomain data) {
		// TODO Auto-generated method stub
		
	}
/*
	private final CityRepository cityRepository;

	public CityNameForStateDoesNotExistRuleImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public void validate(String cityName, UUID stateId) {
		// Inicializa el filtro
		CityEntity filter = new CityEntity();
		filter.setName(cityName);
		filter.getState().setId(stateId); // Asegúrate de que el estado está inicializado correctamente

		// Busca ciudades en el repositorio que coincidan con el filtro
		List<CityEntity> cities = cityRepository.findByFilter(filter);

		// Lanza una excepción si ya existe una ciudad con ese nombre en el estado dado
		if (!cities.isEmpty()) {
			throw CityNameForStateDoesExistException.create(cityName, stateId);
		}
	}
*/
	
}
