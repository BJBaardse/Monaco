package Controller;

import JWT.Authenticated.AuthenticatedUser;
import JWT.JWT;
import Shared.Models.Services.UserService;
import Shared.Models.Role;
import Shared.Models.Services.VehicleService;
import Shared.Models.User;
import Shared.Models.Vehicle;
import Shared.Models.enums.Brand;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JWT
@Path("Vehicle")
public class VehicleController {
    @Inject
    @AuthenticatedUser
    User user;

    @Inject
    VehicleService vehicleService;

    @Inject
    UserService userService;
    @JWT(Permissions = {Role.DEFAULT,Role.USER})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public List<Vehicle> GetActiveUserVehicle() {

        return vehicleService.GetActiveVehicles(userService.GetUserID(user.getId()));
    }

    @JWT(Permissions = {Role.ADMINISTRATION})
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> GetallVehicles() {
        return vehicleService.GetAllVehicles();
    }

    @JWT(Permissions = {Role.DEFAULT,Role.USER, Role.ADMINISTRATION})
    @GET
    @Path("User")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> GetUserVehicle() {
        return vehicleService.GetVehicles(userService.GetUserID(user.getId()));
    }

    @Path("Update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle UpdatedVehicle(Vehicle vehicle){
        return vehicleService.UpdateVehicle(vehicle, user.getId());
    }

    @Path("remove")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean  DeleteVehicle(@FormParam("id")  int id){
        return vehicleService.RemoveVehicle(id, user.getId());
    }

    @Path("ADD")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle ADDVehicle(Vehicle vehicle){
        vehicle.setOwner(user);
        vehicleService.CreateVehicle(vehicle);
        return vehicle;

    }

    @Path("brand")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Brand> Brand(){
        List<Brand> brand = new ArrayList<>(Arrays.asList(Brand.AUDI,Brand.BMW,Brand.McLaren,Brand.Mercedes,Brand.Porsche));
        return brand;

    }
}
