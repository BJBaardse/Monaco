package shared.models.services;

import shared.models.Kilometertarief;

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

}
