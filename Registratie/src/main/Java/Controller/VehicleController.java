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
     public List<Vehicle> GetActiveUserVehicle() {

        return vehicleService.GetActiveVehicles(userService.GetUserID(user.getId()));
    }

    @Path("Update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle UpdatedVehicle(Vehicle vehicle){
        return vehicleService.UpdateVehicle(vehicle, user.getId());
    }

    @Path("remove/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean  DeleteVehicle(@PathParam("id") int id){
        //vehicle.setOwner(user);
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
}
