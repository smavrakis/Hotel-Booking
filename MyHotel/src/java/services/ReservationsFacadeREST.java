package services;

import entities.Reservations;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Stavros
 */
@Stateless
@Path("entities.reservations")
public class ReservationsFacadeREST extends AbstractFacade<Reservations> {
    @PersistenceContext(unitName = "MyHotelPU")
    private EntityManager em;

    public ReservationsFacadeREST() {
        super(Reservations.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Reservations entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Reservations entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    /*@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Reservations find(@PathParam("id") Integer id) {
        return super.find(id);
    }*/
    
    @GET
    @Path("{username}")
    @Produces({"application/json"})
    public Reservations find(@PathParam("username") String username) {
        Query query = em.createNamedQuery("Reservations.findByUsername");
        query.setParameter("username", username);
        List results = query.getResultList();
        return (Reservations)results.get(0);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Reservations> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Reservations> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
