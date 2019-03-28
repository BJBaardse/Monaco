package Controller;

import JWT.Authenticated.AuthenticatedUser;
import JWT.JWT;
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public User authenticateUser() {
        return user;
    }
}
