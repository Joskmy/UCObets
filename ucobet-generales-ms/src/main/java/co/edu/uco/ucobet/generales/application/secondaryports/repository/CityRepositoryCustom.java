package co.edu.uco.ucobet.generales.application.secondaryports.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;


@Repository
public interface CityRepositoryCustom {
	List<CityEntity> findByFilter(CityEntity filter);
    boolean isCityUsed(UUID cityId);
	boolean existsByNameAndState(String name, StateEntity state);
}
