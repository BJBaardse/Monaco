package controllers;


import com.google.gson.*;
import models.Cartracker;
import services.CartrackerService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("/Cartracker")
public class CartrackerController {

    @EJB
    private CartrackerService cartrackerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCartracker(String cartracker) throws ParseException {
        Gson g = new Gson();
        JsonObject jsonObject = g.fromJson(cartracker, JsonObject.class);
        Cartracker ct = g.fromJson(jsonObject.getAsJsonObject("cartracker"), Cartracker.class);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date dateBegin = simpleDateFormat.parse(ct.getBeginTime());
        Date dateEnd = simpleDateFormat.parse(ct.getEndTime());
        ct.setBeginDateTime(dateBegin);
        ct.setEndDateTime(dateEnd);
        System.out.println(ct.toString());
        // cartrackerService.save(ct);
    }
}