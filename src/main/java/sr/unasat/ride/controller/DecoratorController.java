package sr.unasat.ride.controller;

import sr.unasat.ride.config.JPAConfigurations;
import sr.unasat.ride.dao.DecoratorDAO;
import sr.unasat.ride.entity.Decorator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("decorator")
public class DecoratorController {

        JPAConfigurations jpaConfigurations = new JPAConfigurations();

        private final DecoratorDAO decoratorDAO = new DecoratorDAO(jpaConfigurations.getEntityManager());

        @Path("getDecorators")
        @GET
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public List<Decorator> getCars(){
            return decoratorDAO.selectDecorators();
        }

        @Path("/getDecor")
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Decorator getSingleCar(Decorator decorator){
            return decoratorDAO.selectDecor(decorator.getId());
        }
}
