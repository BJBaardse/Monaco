package Controller;

import JWT.Authenticated.AuthenticatedUser;
import JWT.JWT;
import JWT.Services.UserService;
import Shared.Models.Services.VehicleService;
import Shared.Models.User;
import Shared.Models.Vehicle;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public List<Vehicle> GetUserVehicle() {

        return vehicleService.GetVehicles(userService.GetUserID(user.getId()));
    }

    @Path("Update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle UpdatedVehicle(Vehicle vehicle){
        vehicle.setOwner(user);
        return vehicleService.UpdateVehicle(vehicle);
    }


    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void DeleteVehicle(Vehicle vehicle){
        vehicle.setOwner(user);
        vehicleService.RemoveVehicle(vehicle);
    }

    @Path("ADD")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> ADDVehicle(Vehicle vehicle){
        vehicle.setOwner(user);
        vehicleService.CreateVehicle(vehicle);
        return user.getVehicle();
    }
}
