package sr.unasat.ride.controller;

import sr.unasat.ride.config.JPAConfigurations;
import sr.unasat.ride.dao.CarDAO;
import sr.unasat.ride.entity.Car;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("car")
public class CarController {
    JPAConfigurations jpaConfigurations = new JPAConfigurations();

    private final CarDAO carDAO = new CarDAO(jpaConfigurations.getEntityManager());

    @Path("/getCars")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars(){
        return carDAO.selectCars();
    }

    @Path("/getSingleCar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Car getSingleCar(Car car){
        return carDAO.selectCar(car.getId());
    }

    @Path("/insertCar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addCar(Car carInsert){
        return carDAO.insertCar(carInsert);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateCar(Car carUpdate){
        return carDAO.updateCar(carUpdate);
    }

    @Path("/delete")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCar(Car carDelete){
        return carDAO.deleteCar(carDelete);
    }


}