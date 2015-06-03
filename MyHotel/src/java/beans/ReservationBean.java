/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Reservations;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
