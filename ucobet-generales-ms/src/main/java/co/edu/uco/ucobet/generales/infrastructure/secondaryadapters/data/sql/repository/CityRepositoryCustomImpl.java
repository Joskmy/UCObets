package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.data.sql.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepositoryCustom;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.customs.RepositoryUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.message.enums.MessageCode;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

@Repository("cityRepositoryImpl")
@Transactional
public class CityRepositoryCustomImpl implements CityRepositoryCustom {

	private EntityManager entityManager;

	public CityRepositoryCustomImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<CityEntity> findByFilter(final CityEntity filter) {
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(CityEntity.class);
			var result = query.from(CityEntity.class);

			var predicates = new ArrayList<>();

			if (!ObjectHelper.isNull(filter)) {
				if (!UUIDHelper.isDefault(filter.getId())) {
					predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
				}

				if (!TextHelper.isEmpty(filter.getName())) {
					predicates.add(criteriaBuilder.equal(result.get("name"), filter.getName()));
				}

				if (!UUIDHelper.isDefault(filter.getState().getId())) {
					predicates.add(criteriaBuilder.equal(result.get("state"), filter.getState()));
				}
			}

			query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
			return entityManager.createQuery(query).getResultList();

		} catch (final Exception exception) {
			throw RepositoryUcobetException.create(null, null, exception);
		}
	}

	@Override
	public boolean isCityUsed(final UUID cityId) {
	    try {
	        var criteriaBuilder = entityManager.getCriteriaBuilder();
	        var query = criteriaBuilder.createQuery(Long.class);
	        var root = query.from(CityEntity.class);

	        query.select(criteriaBuilder.count(root))
	             .where(criteriaBuilder.equal(root.get("id"), cityId));

	        Long count = entityManager.createQuery(query).getSingleResult();

	        return count > 0;

	    } catch (final Exception exception) {
	        throw RepositoryUcobetException.create(
	            MessageCatalogStrategy.getContentMessage(MessageCode.M00011), 
	            MessageCatalogStrategy.getContentMessage(MessageCode.M00012), 
	            exception
	        );
	    }
	}

	@Override
	public boolean existsByNameAndState(String name, StateEntity state) {
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(Long.class);
			var root = query.from(CityEntity.class);

			query.select(criteriaBuilder.count(root))
					.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("name"), name),
							criteriaBuilder.equal(root.get("state").get("id"), state.getId())));

			Long count = entityManager.createQuery(query).getSingleResult();

			return count > 0;

		} catch (final Exception exception) {
			throw RepositoryUcobetException.create(null, null, exception);
		}
	}

}
