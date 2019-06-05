package services;

import models.Cartracker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CartrackerService {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Cartracker cartracker){
        entityManager.persist(cartracker);
    }
}