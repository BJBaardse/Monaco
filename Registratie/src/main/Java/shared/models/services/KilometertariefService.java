package shared.models.services;

import shared.models.Kilometertarief;
import shared.models.KilometertariefEnergy;
import shared.models.KilometertariefStreet;
import shared.models.enums.Energy;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class KilometertariefService {

    @PersistenceContext
    private EntityManager em;


    public List<Kilometertarief> GetAll(){
        return em.createNamedQuery("All", Kilometertarief.class).getResultList();
    }

    public boolean update(Kilometertarief kilometertarief){
        em.getTransaction().begin();
        em.merge(kilometertarief);
        em.getTransaction().commit();
        return true;
    }

    public boolean Add(Kilometertarief kilometertarief){
        em.getTransaction().begin();
        em.persist(kilometertarief);
        em.getTransaction().commit();
        return true;
    }


    public List<KilometertariefEnergy> GetEngeryLabel(Energy energy){

        return em.createNamedQuery("GetEnergy",KilometertariefEnergy.class).setParameter("energy",energy).getResultList();
    }

    public List<KilometertariefStreet> GetAllStreet(){
        return em.createNamedQuery("AllStreet", KilometertariefStreet.class).getResultList();
    }

    public List<KilometertariefStreet> GetStreet(String street){
        return em.createNamedQuery("GetStreet", KilometertariefStreet.class).setParameter("street",street).getResultList();
    }

}
