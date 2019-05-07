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

    public List<Vehicle> GetAllVehicles(){
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

    public List<Vehicle> GetActiveVehicles(User u){
        TypedQuery<Vehicle> query = em.createNamedQuery("UserVehiclesActive", Vehicle.class).setParameter("owner", u);
        return query.getResultList();
    }

    public void CreateVehicle(Vehicle vehicle){


        em.getTransaction().begin();
        //User u = em.find(User.class,user.getId());
        em.persist(vehicle);
        em.getTransaction().commit();

    }

    public boolean RemoveVehicle(int vehicleID,int userID){
        em.createNamedQuery("UserVehiclesDelete").setParameter("owner", userID).setParameter("vehicleID", vehicleID).executeUpdate();
        return true;

    }

    public Vehicle UpdateVehicle(Vehicle vehicle,int UserID){

        Vehicle v = em.find(Vehicle.class,vehicle.getVehicleID());
        if(v.getOwner().getId() == UserID) {
            em.getTransaction().begin();
            vehicle.setOwner(v.getOwner());
            em.merge(vehicle);
            em.getTransaction().commit();
            return vehicle;
        }


        return null;
    }

}
