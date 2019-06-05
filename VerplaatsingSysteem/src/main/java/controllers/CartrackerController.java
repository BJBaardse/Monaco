package controllers;

import com.google.gson.Gson;
import models.Cartracker;
import services.CartrackerService;

import javax.ejb.EJB;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/Cartracker")
public class CartrackerController {

    @EJB
    private CartrackerService cartrackerService;

    @POST
    public void saveCartracker(@FormParam("cartracker") String cartracker){
        Gson g = new Gson();
        Cartracker ct = g.fromJson(cartracker, Cartracker.class);
        System.out.println("in save cartracker." + ct.toString());
        // cartrackerService.save(cartracker);
    }
}