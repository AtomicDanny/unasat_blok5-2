package sr.unasat.ride.dao;

import sr.unasat.ride.entity.UserPrivilege;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserPrivilegeDAO {
    private EntityManager entityManager;

    public UserPrivilegeDAO(){}

    public UserPrivilegeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insertUserPrivilege(UserPrivilege userPrivilege) {
        entityManager.getTransaction().begin();
        entityManager.persist(userPrivilege);
        entityManager.getTransaction().commit();
    }

    public UserPrivilege selectUserPrivilege(long userId) {
        entityManager.getTransaction().begin();
        String jpql = "select u from UserPrivilege u where u.userId = :userId";
        TypedQuery<UserPrivilege> query = entityManager.createQuery(jpql, UserPrivilege.class);
        query.setParameter("userId", userId);
        UserPrivilege userPrivilege = query.getSingleResult();
        entityManager.getTransaction().commit();
        return userPrivilege;
    }

}
