package co.edu.uco.bodyhealty.servicios.infrastructure.secondaryadapters.data.sql.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.bodyhealty.servicios.application.secondaryports.entity.ServicioEntity;
import co.edu.uco.bodyhealty.servicios.application.secondaryports.repository.ServicioRepositoryCustom;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.custom.RepositoryBodyHealtyException;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.enums.MessageCode;
import co.edu.uco.bodyhealty.servicios.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import jakarta.persistence.EntityManager;


@Repository("servicioRepositoryImpl")
@Transactional
public class ServicioRepositoryCustomImpl implements ServicioRepositoryCustom {

	private final EntityManager entityManager;

    public ServicioRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
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

}
