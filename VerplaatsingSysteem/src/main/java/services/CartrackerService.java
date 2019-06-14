package services;

import models.Cartracker;
import models.Movements;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}