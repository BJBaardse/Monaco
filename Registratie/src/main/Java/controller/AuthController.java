package controller;


import shared.models.services.UserService;
import shared.models.Role;
import shared.models.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/authentication")
public class AuthController {
    @Inject
    private UserService userService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("email") String email,
                                     @FormParam("password") String password) {


        try {
//            String username = credentials.getUsername();
//            String password = credentials.getPassword();

            // Authenticate the user using the credentials provided
            User user = authenticate(email, password);

            // Issue a token for the user
            String token = issueToken(user);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @POST
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response RegisterUser(@FormParam("Name") String name,
                                     @FormParam("password") String password,@FormParam("lastname") String lastname,@FormParam("email") String email, @FormParam("BSN") int BSN) {

        User u = new User(name,lastname,email,password,new ArrayList<Role>(Collections.singleton(Role.DEFAULT)),BSN);
        try {
//            String username = credentials.getUsername();
//            String password = credentials.getPassword();

            // Authenticate the user using the credentials provided
            userService.createUser(u);
            User user = authenticate(u.getEmail(), password);

            String token = issueToken(user);
            // Return the token on the response


            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    private User authenticate(String Email, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
        User user = userService.GetUser(Email,password);
        if(user != null){
            return user;

        }
        else {
            throw new Exception();
        }
    }

    private String issueToken(User user) {
        // Issue a token (can be a random String persisted to a database or a jwt token)
        // The issued token must be associated to a user
        // Return the issued token
        Gson g = new GsonBuilder().create();

        try {
            Algorithm algorithm = Algorithm.HMAC256("powerabusers");
            String token = JWT.create()
                    .withIssuer("Monaco")
                    .withClaim("ID",user.getId())
                    .withClaim("Roles", g.toJson(user.getRoles(),new TypeToken<List<Role>>() {}.getType()))
                    .withClaim("Name",user.getName())
                    .sign(algorithm);
            return token;


        }catch (Exception e){
           return "";
        }

    }
}