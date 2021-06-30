package sr.unasat.ride.dao;

import sr.unasat.ride.entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarDAO {
    private final EntityManager entityManager;

    public CarDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Car selectCar(long id) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Car c where c.id = :carId";
        TypedQuery<Car> query = entityManager.createQuery(jpql, Car.class);
        query.setParameter("carId", id);
        Car car = query.getSingleResult();
        entityManager.getTransaction().commit();
        return car;
    }

    public List<Car> selectCars() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Car c";
        TypedQuery<Car> query = entityManager.createQuery(jpql, Car.class);
        List<Car> car = query.getResultList();
        entityManager.getTransaction().commit();
        return car;
    }

    public String deleteCar(Car carDelete) {
        try {
            entityManager.getTransaction().begin();
            String sql = "delete from Car c where c.id = :carId";
            Query query = entityManager.createQuery(sql);
            query.setParameter("carId", carDelete.getId());
            query.executeUpdate();
            entityManager.getTransaction().commit();
            return "Car removed";
        }catch (Exception e){
            e.printStackTrace();
            return "Car removal failed: " + e.toString();
        }
    }

    public String insertCar(Car car) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(car);
            entityManager.getTransaction().commit();
            return "Car created";
        }catch (Exception e){
            e.printStackTrace();
            return "Failed to add car : " + e.toString();
        }
    }


    public String updateCar(Car carUpdate){
//        try{
//            entityManager.getTransaction().begin();
//            entityManager.persist(carUpdate);
//            entityManager.getTransaction().commit();
//            return "Updated";
//        }catch(Exception e){
//            e.printStackTrace();
//            return "Failed to updated car : " + e.toString();
//        }

        try {
            entityManager.getTransaction().begin();
            String sql = "update Car c set c.brand = :brandId, c.classification = :classId, c.model = :modelData,c.bouwjaar=:bouwjaarData, c.price=:priceData where c.id = :updateId";
            Query query = entityManager.createQuery(sql);
            query.setParameter("updateId", carUpdate.getId());
            query.setParameter("brandId", carUpdate.getBrand());
            query.setParameter("classId", carUpdate.getClassification());
            query.setParameter("modelData", carUpdate.getModel());
            query.setParameter("bouwjaarData", carUpdate.getBouwjaar());
            query.setParameter("priceData", carUpdate.getPrice());
            query.executeUpdate();
            entityManager.getTransaction().commit();
            return "Car updated";
        }catch (Exception e){
            e.printStackTrace();
            return "Car update failed: " + e.toString();
        }
    }

}