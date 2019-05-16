package jwt.authenticated;

import shared.models.services.UserService;
import shared.models.User;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@RequestScoped
public class AuthentictedUserProducer {
    @Produces
    @RequestScoped
    @AuthenticatedUser
    private User authenticatedUser;

    @Inject
    UserService userService;

    public void handleAuthenticationEvent(@Observes @AuthenticatedUser int ID){
        this.authenticatedUser = findUser(ID);
    }

    private User findUser(int id) {
        return userService.GetUserID(id);
    }

}
