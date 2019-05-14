package Controller;

import JWT.JWT;
import Shared.Models.Billing.Bill;
import Shared.Models.Role;
import Shared.Models.Services.BillService;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bill")
public class BillController {

    @Inject
    BillService billService;

    @JWT(Permissions = Role.ADMINISTRATION, Usercheck = false)
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bill> getAll(){

        return billService.GetAll();
    }
}
