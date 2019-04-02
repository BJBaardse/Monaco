package Shared.Models.Services;

import Shared.Models.User;
import Shared.Models.Vehicle;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class VehicleService {

    @PersistenceContext
    private EntityManager em;

    public List<Vehicle> GetVehicles(){
        TypedQuery<Vehicle> query = em.createNamedQuery("ALLVehicles", Vehicle.class);
        return query.getResultList();
    }

    public Vehicle GetVehicles(int ID){
        return em.createNamedQuery("VehicleID", Vehicle.class).setParameter("ID", ID).getSingleResult();
    }

    public List<Vehicle> GetVehicles(User u){
        TypedQuery<Vehicle> query = em.createNamedQuery("UserVehicles", Vehicle.class).setParameter("owner", u);
        return query.getResultList();
    }

    public void CreateVehicle(Vehicle vehicle){
        em.getTransaction().begin();
        em.persist(vehicle);
        em.getTransaction().commit();
        em.flush();
    }

    public void RemoveVehicle(Vehicle vehicle){
        em.getTransaction().begin();
        em.remove(vehicle);
        em.getTransaction().commit();
        em.flush();
    }

    public Vehicle UpdateVehicle(Vehicle vehicle){
        em.getTransaction().begin();
        em.merge(vehicle);
        em.getTransaction().commit();
        em.flush();

        return vehicle;
    }

}
