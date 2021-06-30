package sr.unasat.ride.dao;

import sr.unasat.ride.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserDAO {
    private EntityManager entityManager;

    public UserDAO(){}

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String insertUser(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return "User insertion succeeded";
        }catch (Exception e){
            e.printStackTrace();
            return "User insertion failed: " + e.toString();
        }
    }

    public boolean Check(String userEmail){
        entityManager.getTransaction().begin();
        String jpql = "select u from User u where u.userEmail = :userEmail";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("userEmail", userEmail);
        User user = query.getResultList().stream().findFirst().orElse(null);
        if(user == null){
            return false;
        }else{
            if(user.getUserEmail().equals(userEmail)){
                return true;
            }
        }
        entityManager.getTransaction().commit();
        return false;
    }

    public boolean Pass(String userEmail, String userPassword){
        if(userEmail != null){
            return userPassword != null;
        }else{
            return false;
        }
    }
}
