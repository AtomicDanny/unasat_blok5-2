package sr.unasat.ride.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConfigurations {

    private final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    private final EntityManager entityManager = factory.createEntityManager();

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
