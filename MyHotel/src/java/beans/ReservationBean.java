/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        //java.util.Date fromDate = new java.util.Date(from.getTime());
        //java.util.Date toDate = new java.util.Date(to.getTime());
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
