package controller;

import jwt.JWT;
import jwt.authenticated.AuthenticatedUser;
import shared.models.User;
import shared.models.Vehicle;
import shared.models.billing.Bill;
import shared.models.Role;
import shared.models.billing.BillLogic;
import shared.models.movements.Imovement;
import shared.models.movements.Irit;
import shared.models.movements.move;
import shared.models.movements.rit;
import shared.models.services.BillService;
import shared.models.services.VehicleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/bill")
public class BillController {

    @Inject
    BillService billService;

    @Inject
    VehicleService vehicleService;
    @Inject
    BillLogic billLogic;

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

    //@JWT(Permissions = Role.ADMINISTRATION)
    @POST
    @Path("generate/{vehicle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bill Createbill( @PathParam("vehicle") int vehicle){

        Vehicle vehicleobj = vehicleService.GetVehicles(vehicle);

        rit ritobj = new rit();

        ritobj.setDate(new Date());

        List<Imovement> imovements = new ArrayList<>();

        move move1 = new move();
        move1.setStreet("beta");
        move1.setDuration((double) new Date().getTime());
        move1.setDistance(200);
        imovements.add(move1);

        move move2 = new move();
        move2.setStreet("fastlane");
        move2.setDuration((double) new Date().getTime());
        move2.setDistance(186);
        imovements.add(move2);

        ritobj.setMovements(imovements);
        List<Irit>  rits = new ArrayList<>();
        rits.add(ritobj);

        Bill bill = billLogic.CalculateBill(rits,vehicleobj);
        return bill;
    }
}
