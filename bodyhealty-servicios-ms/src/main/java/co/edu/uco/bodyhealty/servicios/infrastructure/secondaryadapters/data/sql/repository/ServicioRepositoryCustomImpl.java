package co.edu.uco.bodyhealty.servicios.infrastructure.secondaryadapters.data.sql.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.entity.ServicioEntity;
import co.edu.uco.bodyhealty.servicios.application.secondaryports.repository.ServicioRepositoryCustom;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RepositoryBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.NumericHelper;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;


@Repository("servicioRepositoryImpl")
@Transactional
public class ServicioRepositoryCustomImpl implements ServicioRepositoryCustom {

	private final EntityManager entityManager;

    public ServicioRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    @Override
	public List<ServicioEntity> findByFilter(final ServicioEntity filter) {
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(ServicioEntity.class);
			var result = query.from(ServicioEntity.class);

			var predicates = new ArrayList<>();

			if (!ObjectHelper.isNull(filter)) {
				if (!UUIDHelper.isDefault(filter.getId())) {
					predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
				}

				if (!TextHelper.isEmpty(filter.getNombreServicio())) {
					predicates.add(criteriaBuilder.equal(result.get("nombreServicio"), filter.getNombreServicio()));
				}
				
				if (!TextHelper.isEmpty(filter.getDescripcion())) {
					predicates.add(criteriaBuilder.equal(result.get("descripcion"), filter.getNombreServicio()));
				}
				
				if (!NumericHelper.isNull(filter.getDuracionEstimada())) {
					predicates.add(criteriaBuilder.equal(result.get("duracionEstimada"), filter.getNombreServicio()));
				}
			}

			query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
			return entityManager.createQuery(query).getResultList();

		} catch (final Exception exception) {
			final var messageUser = MessageCatalogStrategy.getContentMessage(MessageCode.M00022);
			final var messageTechnical = MessageCatalogStrategy.getContentMessage(MessageCode.M00023);
			throw RepositoryBodyHealtyException.create(messageUser, messageTechnical, exception);
		}
	}

    

    @Override
    public boolean isServiceUsed(UUID serviceId) {
        try {
            var criteriaBuilder = entityManager.getCriteriaBuilder();
            var query = criteriaBuilder.createQuery(Long.class);
            var root = query.from(ServicioEntity.class);

            query.select(criteriaBuilder.count(root))
                 .where(criteriaBuilder.equal(root.get("id"), serviceId));

            Long count = entityManager.createQuery(query).getSingleResult();
            return count > 0;

        } catch (Exception exception) {
            throw RepositoryBodyHealtyException.create(
                MessageCatalogStrategy.getContentMessage(MessageCode.M00019, serviceId.toString()),
                MessageCatalogStrategy.getContentMessage(MessageCode.M00020, serviceId.toString()),
                exception
            );
        }
    }
    
    @Override
    public boolean existsByName(String name) {
        try {
            var criteriaBuilder = entityManager.getCriteriaBuilder();
            var query = criteriaBuilder.createQuery(Long.class);
            var root = query.from(ServicioEntity.class);

            query.select(criteriaBuilder.count(root))
                 .where(criteriaBuilder.equal(root.get("nombreServicio"), name));

            Long count = entityManager.createQuery(query).getSingleResult();
            return count > 0;

        } catch (final Exception exception) {
            final var messageUser = MessageCatalogStrategy.getContentMessage(MessageCode.M00024);
            final var messageTechnical = MessageCatalogStrategy.getContentMessage(MessageCode.M00025);
            throw RepositoryBodyHealtyException.create(messageUser, messageTechnical, exception);
        }
    }

}
