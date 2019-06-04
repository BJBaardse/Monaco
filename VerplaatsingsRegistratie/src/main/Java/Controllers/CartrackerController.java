package Controllers;

import models.Cartracker;
import services.CartrackerService;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/Cartracker")
public class CartrackerController {

    @EJB
    private CartrackerService cartrackerService;

    @POST
    public void saveCartracker(@FormParam("cartracker") Cartracker cartracker){

        cartrackerService.save(cartracker);
    }
}
