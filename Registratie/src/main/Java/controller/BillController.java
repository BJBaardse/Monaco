package controller;

import jwt.JWT;
import jwt.authenticated.AuthenticatedUser;
import shared.models.User;
import shared.models.billing.Bill;
import shared.models.Role;
import shared.models.services.BillService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bill")
public class BillController {

    @Inject
    BillService billService;

    @Inject
    @AuthenticatedUser
    User user;


    @JWT(Permissions = Role.ADMINISTRATION, Usercheck = false)
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bill> getAll(){

        return billService.GetAll();
    }


    @JWT(Permissions = Role.USER)
    @GET
    @Path("user/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bill> getAllUser(){
        return billService.GetUserID(user.getId());
    }
}
