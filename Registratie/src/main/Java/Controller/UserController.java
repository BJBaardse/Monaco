package Controller;

import JWT.Authenticated.AuthenticatedUser;
import JWT.JWT;
import JWT.Services.UserService;
import Shared.Models.IUser;
import Shared.Models.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@JWT
@Path("User")
public class UserController {
    @Inject
    @AuthenticatedUser
    User user;

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public IUser authenticateUser() {
        return user;
    }
    @Path("userID")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public IUser UserID() {
        return userService.GetUserID(user.getId());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public IUser UpdateUser(User u) {
        return userService.UpdateUser(userService.GetUserID(user.getId()));
    }

}
