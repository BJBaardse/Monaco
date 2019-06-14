package services;

import models.Cartracker;
import models.Movements;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class CartrackerService {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Cartracker cartracker){

        for(Movements m : cartracker.getMovements())
        {
            entityManager.persist(m);
        }
        entityManager.merge(cartracker);
    }

    public List<Cartracker> GetCartracker(int ID, Date date){

        return entityManager.createNamedQuery("GetRide",Cartracker.class).setParameter("ID",ID).setParameter("date",date).getResultList();
    }
}