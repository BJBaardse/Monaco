package shared.models.services;


import shared.models.billing.Bill;
import shared.models.billing.Movement;
import shared.models.billing.Ride;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class BillService {

    @PersistenceContext
    private EntityManager em;


    public List<Bill> GetAll(){
        List<Bill> bills = em.createNamedQuery("Allbill", Bill.class).getResultList();

        for(Bill bill : bills){
            bill.CalcData();
//            bill.CalcPrices();
//            bill.CalcKilometer();
        }
        return  bills; //em.createNamedQuery("Allbill", Bill.class).getResultList();
    }




    public List<Bill> GetUserID(int id){
        List<Bill> bills = em.createNamedQuery("Userbills", Bill.class).setParameter("ID",id).getResultList();

        for(Bill bill : bills){
            bill.CalcData();
//            bill.CalcPrices();
////            bill.CalcKilometer();
        }
        return  bills; //em.createNamedQuery("Allbill", Bill.class).getResultList();
    }


    public Bill saveBill(Bill bill){
    em.getTransaction().begin();
        for(Ride r : bill.getRides()){

            for(Movement m : r.getMovements()){
                em.persist(m);
            }
            em.persist(r);
        }

        em.persist(bill);

        em.getTransaction().commit();

        return bill;
    }


    public List<Bill> GetAllbyYear(Date date){
        return em.createNamedQuery("BillYear", Bill.class).setParameter("date",date).getResultList();
    }

    public List<Bill> GetAllbyUserandYear(int id, Date date){
        return em.createNamedQuery("BillYearUser", Bill.class).setParameter("date",date).setParameter("ID",id).getResultList();
    }







}
