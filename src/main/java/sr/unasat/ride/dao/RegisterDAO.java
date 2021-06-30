package sr.unasat.ride.dao;


import sr.unasat.ride.entity.Register;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class RegisterDAO {

    private final EntityManager entityManager;

    public RegisterDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Register retrieveOneRegister(long id) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Register c where c.id = :registerId";
        TypedQuery<Register> query = entityManager.createQuery(jpql, Register.class);
        query.setParameter("registerId", id);
        Register register = query.getSingleResult();
        entityManager.getTransaction().commit();
        return register;
    }

    public List<Register> retrieveRegisterList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Register c";
        TypedQuery<Register> query = entityManager.createQuery(jpql, Register.class);
        List<Register> registers = query.getResultList();
        entityManager.getTransaction().commit();
        return registers;
    }

    public String insertRegister(Register register) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(register);
            entityManager.getTransaction().commit();
            return "Registered";
        }catch (Exception e){
            e.printStackTrace();
            return "Registration failed: " + e.toString();
        }
    }

    public String deleteRegister(Register registerDelete) {
//        try{
//            entityManager.getTransaction().begin();
//            entityManager.remove(registerDelete);
//            entityManager.getTransaction().commit();
//            return "Record removed";
//        }catch(Exception e){
//            e.printStackTrace();
//            return "Failed to remove record : " + e.toString();
//        }
        try {
            entityManager.getTransaction().begin();
            String sql = "DELETE FROM Register k where k.id = :idDelete";
            Query query = entityManager.createQuery(sql);
            query.setParameter("idDelete", registerDelete.getId());
            query.executeUpdate();
            entityManager.getTransaction().commit();
            return "Record deletion succeeded";
        }catch (Exception e){
            e.printStackTrace();
            return "Record deletion failed: " + e.toString();
        }
    }
}
