package sr.unasat.ride.controller;

import sr.unasat.ride.builder.DecoratorBuilder;
import sr.unasat.ride.builder.RegisterBuilder;
import sr.unasat.ride.config.JPAConfigurations;
import sr.unasat.ride.dao.DecoratorDAO;
import sr.unasat.ride.dao.RegisterDAO;
import sr.unasat.ride.entity.Decorator;
import sr.unasat.ride.entity.Register;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("register")
public class RegisterController {

    JPAConfigurations jpaConfigurations = new JPAConfigurations();

    private final RegisterDAO registerDAO = new RegisterDAO(jpaConfigurations.getEntityManager());
    private final DecoratorDAO decoratorDAO = new DecoratorDAO(jpaConfigurations.getEntityManager());

    @Path("/getAllRegister")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Register> getRegister(){
        return registerDAO.retrieveRegisterList();
    }

    @Path("/getOneRegister")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Register getOne(Register register){
        return registerDAO.retrieveOneRegister(register.getId());
    }

    @Path("/delete")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteKlant(Register register){
        return registerDAO.deleteRegister(register);
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
//    public String addRegistration(Register register){
//        return registerDAO.insertRegister(register);
//    }
    public String addRegister(Register register){
        Register registerBuilder1= new RegisterBuilder(register.getCar(),register.getKlant(),register.getStart_date(),register.getEnd_date(),register.getTotal()).build();
        List<Decorator> decoratorList = new ArrayList<>();
        Decorator insurance = decoratorDAO.selectDecor(1);
        decoratorList.add(insurance);
        registerBuilder1.setDecoratorList(decoratorList);
        return registerDAO.insertRegister(registerBuilder1);
    }

}
