package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import jwt.JWT;
import jwt.authenticated.AuthenticatedUser;
import shared.models.User;
import shared.models.Vehicle;
import shared.models.billing.Bill;
import shared.models.Role;
import shared.models.billing.BillLogic;
import shared.models.movements.Irit;
import shared.models.movements.rit;
import shared.models.services.BillService;
import shared.models.services.VehicleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

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


    @JWT(Permissions = Role.ADMINISTRATION, Usercheck = false)
    @GET
    @Path("date")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bill> getAll(Date date){

        return billService.GetAllbyYear(date);
    }




    @JWT(Permissions = Role.USER)
    @GET
    @Path("user/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bill> getAllUser(){
        return billService.GetUserID(user.getId());
    }


    @JWT(Permissions = Role.USER)
    @GET
    @Path("user/date")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bill> getAllUser(Date date)
    {
        return billService.GetAllbyUserandYear(user.getId(),date);
    }

    //@JWT(Permissions = Role.ADMINISTRATION)
    @POST
    @Path("generate/{vehicle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bill Createbill( @PathParam("vehicle") int vehicle) throws IOException, UnirestException {

        Vehicle vehicleobj = vehicleService.GetVehicles(vehicle);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());


        List<rit> rides = Createbill(vehicleobj,calendar.getTimeInMillis());

//        rit ritobj = new rit();
//
//        ritobj.setBeginDateTime(new Date());
//
//        List<Imovement> imovements = new ArrayList<>();
//
//        move move1 = new move();
//        move1.setStreet("beta");
//        move1.setDuration((double) new Date().getTime());
//        move1.setDistance(200);
//        imovements.add(move1);
//
//        move move2 = new move();
//        move2.setStreet("fastlane");
//        move2.setDuration((double) new Date().getTime());
//        move2.setDistance(186);
//        imovements.add(move2);
//
//        ritobj.setMovements(imovements);
//        List<Irit>  rits = new ArrayList<>();
//        rits.add(ritobj);

        Bill bill = billLogic.CalculateBill(rides,vehicleobj);

        billService.saveBill(bill);
        return bill;
    }


    private List<rit> Createbill(Vehicle vehicle,long date) throws IOException, UnirestException {

        Gson gson = new GsonBuilder().create();


        HttpResponse<JsonNode> jsonResponse = Unirest.get("http://192.168.25.110:8080/VerplaatsingSysteem/Cartracker/{ID}/{date}")
                .routeParam("ID", String.valueOf(vehicle.getCartrackerID()))
                .routeParam("date", String.valueOf(date))
                .asJson();


        try {

            System.out.println(jsonResponse.getBody());
            List<rit> rides = new ArrayList<>();

            Type listType = new TypeToken<List<rit>>() {
            }.getType();

            rides.addAll(gson.fromJson(jsonResponse.getBody().toString(), listType));

            return rides;

        }catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }


//        Bill bill = billLogic.CalculateBill(rides,vehicle);
//
//        billService.saveBill(bill);

    }

//
//    @GET
//    @Path("generate2")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<rit> Generateshit() throws IOException, UnirestException {
//
//
//            Vehicle vehicleobj = vehicleService.GetVehicles(1);
//
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(new Date());
//
//            return Createbill(vehicleobj,calendar.getTimeInMillis());
//
//
//    }
}
