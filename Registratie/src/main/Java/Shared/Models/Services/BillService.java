package Shared.Models.Services;


import JWT.JWT;
import Shared.Models.Billing.Bill;
import Shared.Models.Role;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Stateless
public class BillService {

    @PersistenceContext
    private EntityManager em;


    public List<Bill> GetAll(){
        List<Bill> bills = em.createNamedQuery("Allbill", Bill.class).getResultList();

        for(Bill bill : bills){
            bill.CalcPrice();
            bill.CalcKilometer();
        }
        return  bills; //em.createNamedQuery("Allbill", Bill.class).getResultList();
    }



}
