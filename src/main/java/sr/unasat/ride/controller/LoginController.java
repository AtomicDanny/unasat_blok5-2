package sr.unasat.ride.controller;

import sr.unasat.ride.builder.UserBuilder;
import sr.unasat.ride.config.JPAConfigurations;
import sr.unasat.ride.dao.UserDAO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("login")
public class LoginController {

    JPAConfigurations jpaConfigurations = new JPAConfigurations();

    private final UserDAO userDAO = new UserDAO(jpaConfigurations.getEntityManager());

    @Path("/authentication")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean login(UserBuilder userBuilder){
        return userDAO.Check(userBuilder.userEmail);
    }
}
