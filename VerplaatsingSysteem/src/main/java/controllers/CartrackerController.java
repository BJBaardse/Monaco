package controllers;


import com.google.gson.*;
import models.Cartracker;
import models.Date;
import services.CartrackerService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/Cartracker")
public class CartrackerController {

    @Inject
    private CartrackerService cartrackerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCartracker(String cartracker){
        Gson g = new Gson();
        JsonObject jsonObject = g.fromJson(cartracker, JsonObject.class);
        Cartracker ct = g.fromJson(jsonObject.getAsJsonObject("cartracker"), Cartracker.class);
        Date beginDatetime = ct.convertStringToDate(ct.getBeginTime());
        Date endDatetime = ct.convertStringToDate(ct.getEndTime());
        ct.setEndDateTime(endDatetime);
        ct.setBeginDateTime(beginDatetime);
        System.out.println(ct.toString());
        cartrackerService.save(ct);
    }
}