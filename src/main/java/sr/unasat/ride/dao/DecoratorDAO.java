package sr.unasat.ride.dao;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import sr.unasat.ride.entity.Decorator;

public class DecoratorDAO {

    private final EntityManager entityManager;

    public DecoratorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Decorator selectDecor(long id) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Decorator c where c.id = :decId";
        TypedQuery<Decorator> query = entityManager.createQuery(jpql, Decorator.class);
        query.setParameter("decId", id);
        Decorator dec = query.getSingleResult();
        entityManager.getTransaction().commit();
        return dec;
    }

    public List<Decorator> selectDecorators() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Decorator c";
        TypedQuery<Decorator> query = entityManager.createQuery(jpql, Decorator.class);
        List<Decorator> dec = query.getResultList();
        entityManager.getTransaction().commit();
        return dec;
    }

}
