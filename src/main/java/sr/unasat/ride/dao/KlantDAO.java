package sr.unasat.ride.dao;

import sr.unasat.ride.entity.Klant;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class KlantDAO {

    private EntityManager entityManager;

    public KlantDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Klant> retrieveKlantList() {
        entityManager.getTransaction().begin();
        String jpql = "select k from Klant k";
        TypedQuery<Klant> query = entityManager.createQuery(jpql, Klant.class);
        List<Klant> klantList = query.getResultList();
        entityManager.getTransaction().commit();
        return klantList;
    }

    public String insertKlant(Klant klant) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(klant);
            entityManager.getTransaction().commit();
            return "Klant created";
        }catch (Exception e){
            e.printStackTrace();
            return "Failed to add klant : " + e.toString();
        }
    }

    public Klant selectKlant(long id) {
        entityManager.getTransaction().begin();
        String jpql = "select k from Klant k where k.id = :id";
        TypedQuery<Klant> query = entityManager.createQuery(jpql, Klant.class);
        query.setParameter("id", id);
        Klant klant = query.getSingleResult();
        entityManager.getTransaction().commit();
        return klant;
    }

    public String updateKlant(Klant updateKlant){
//        try{
//            entityManager.getTransaction().begin();
//            entityManager.persist(updateKlant);
//            entityManager.getTransaction().commit();
//            return "Klant updated";
//        }catch(Exception e){
//            e.printStackTrace();
//            return "Failed to updated klant : " + e.toString();
//        }

        try {
            entityManager.getTransaction().begin();
            String sql = "update Klant k set k.naam = :naam, k.geslacht = :geslacht, k.telNummer = :tel_nummer,k.email=:email where k.id = :id";
            Query query = entityManager.createQuery(sql);
            query.setParameter("id", updateKlant.getId());
            query.setParameter("naam", updateKlant.getNaam());
            query.setParameter("geslacht", updateKlant.getGeslacht());
            query.setParameter("tel_nummer", updateKlant.getTelNummer());
            query.setParameter("email", updateKlant.getEmail());
            query.executeUpdate();
            entityManager.getTransaction().commit();
            return "Klant update succeeded";
        }catch (Exception e){
            e.printStackTrace();
            return "Klant update failed: " + e.toString();
        }
    }

    public String deleteKlant(Klant klantDelete) {
//        try{
//            entityManager.getTransaction().begin();
//            entityManager.remove(klant);
//            entityManager.getTransaction().commit();
//            return "Klant removed";
//        }catch(Exception e){
//            e.printStackTrace();
//            return "Failed to remove klant : " + e.toString();
//        }
        try {
            entityManager.getTransaction().begin();
            String sql = "DELETE FROM Klant k where k.id = :idDelete";
            Query query = entityManager.createQuery(sql);
            query.setParameter("idDelete", klantDelete.getId());
            query.executeUpdate();
            entityManager.getTransaction().commit();
            return "Klant deletion succeeded";
        }catch (Exception e){
            e.printStackTrace();
            return "Klant deletion failed: " + e.toString();
        }
    }

}
