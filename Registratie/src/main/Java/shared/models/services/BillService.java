package shared.models.services;


import shared.models.billing.Bill;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
