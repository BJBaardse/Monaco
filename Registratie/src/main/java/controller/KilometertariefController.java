package controller;

import jwt.JWT;
import shared.models.*;
import shared.models.services.KilometertariefService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@JWT(Usercheck = false)
@Path("Kilometertarief")
public class KilometertariefController {

    @Inject
    KilometertariefService kilometertariefService;


    @JWT(Permissions = {Role.ADMINISTRATION}, Usercheck = false)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public List<Kilometertarief> Getall() {

        return kilometertariefService.GetAll();
    }


    @JWT(Permissions = {Role.ADMINISTRATION}, Usercheck = false)
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Add(Kilometertarief kilometertarief) {

        return kilometertariefService.Add(kilometertarief);
    }

    @JWT(Permissions = {Role.ADMINISTRATION}, Usercheck = false)
    @PUT
    @Path("street")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Addstreet(KilometertariefStreet kilometertarief) {

        return kilometertariefService.Add(kilometertarief);
    }

    @JWT(Permissions = {Role.ADMINISTRATION}, Usercheck = false)
    @PUT
    @Path("enegry")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Addstreet(KilometertariefEnergy kilometertarief) {

        return kilometertariefService.Add(kilometertarief);
    }

       @JWT(Permissions = {Role.ADMINISTRATION}, Usercheck = false)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Update(Kilometertarief kilometertarief) {

        return kilometertariefService.update(kilometertarief);
    }

    @JWT(Permissions = {Role.ADMINISTRATION}, Usercheck = false)
    @POST
    @Path("street")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Update(KilometertariefStreet kilometertarief) {

        return kilometertariefService.update(kilometertarief);
    }

    @JWT(Permissions = {Role.ADMINISTRATION}, Usercheck = false)
    @POST
    @Path("engery")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Update(KilometertariefEnergy kilometertarief) {

        return kilometertariefService.update(kilometertarief);
    }


    @GET
    @Path("get/street")
    @Produces(MediaType.APPLICATION_JSON)
    public List<KilometertariefStreet> getstreet(@QueryParam("street") String street) {
        return kilometertariefService.GetStreet(street);
    }




}
