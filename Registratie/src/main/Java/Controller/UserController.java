package Controller;

import JWT.Authenticated.AuthenticatedUser;
import JWT.JWT;
import Shared.Models.Services.UserService;
import Shared.Models.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
     public User authenticateUser() {
        return userService.GetUserID(user.getId());
    }
    @Path("userID")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User UserID() {
        return userService.GetUserID(user.getId());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User UpdateUser(User u) {
        //return u;
        return userService.UpdateUser(u,user.getId());
    }

}
