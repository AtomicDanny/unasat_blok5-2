package sr.unasat.ride.controller;

import sr.unasat.ride.config.JPAConfigurations;
import sr.unasat.ride.dao.KlantDAO;
import sr.unasat.ride.entity.Klant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("klanten")
public class KlantenController {
    JPAConfigurations jpaConfigurations = new JPAConfigurations();

    private final KlantDAO klantDAO = new KlantDAO(jpaConfigurations.getEntityManager());

    @Path("/getKlanten")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Klant> getKlanten(){
        return klantDAO.retrieveKlantList();
    }

    @Path("/getKlant")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Klant getKlant(Klant klant){
        return klantDAO.selectKlant(klant.getId());
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addKlant(Klant klant){
        return klantDAO.insertKlant(klant);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateKlant(Klant updateKlant){
        return klantDAO.updateKlant(updateKlant);
    }

    @Path("/delete")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteKlant(Klant klant){
        return klantDAO.deleteKlant(klant);
    }
}
