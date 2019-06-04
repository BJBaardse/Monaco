package Controllers;

import models.Cartracker;
import services.CartrackerService;

import javax.ejb.EJB;
import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Path("/Cartracker")
public class CartrackerController {

    @EJB
    private CartrackerService cartrackerService;

    @POST
    public void saveCartracker(@BeanParam Cartracker cartracker){
        System.out.println("in save cartracker." + cartracker);
        cartrackerService.save(cartracker);
    }
}
