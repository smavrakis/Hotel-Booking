package beans;

import entities.Reservations;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Stavros
 */
@Stateless(name="Reservation")
public class ReservationBean {

    @PersistenceContext
    private EntityManager em;
    
    public void makeReservation(String username, Integer roomNumber, java.sql.Date from, java.sql.Date to){        
        Reservations reservation = new Reservations();
        reservation.setUsername(username);
        reservation.setRoomNumber(roomNumber);
        reservation.setFrom(from);
        reservation.setTo(to);
        
        em.persist(reservation);
    }
    
    public boolean isAvailable(java.sql.Date from, java.sql.Date to, Integer roomNumber){        
        Query query = em.createNamedQuery("Reservations.checkAvailability");
        query.setParameter("roomNumber", roomNumber);
        query.setParameter("from", from);
        query.setParameter("to", to);
        List results = query.getResultList();
        
        if (results.isEmpty()){
            return true;
        }else{
            return false;
        }        
    }
}
