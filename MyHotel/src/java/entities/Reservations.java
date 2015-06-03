/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stavros
 */
@Entity
@Table(name = "reservations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservations.findAll", query = "SELECT r FROM Reservations r"),
    @NamedQuery(name = "Reservations.findByReservationID", query = "SELECT r FROM Reservations r WHERE r.reservationID = :reservationID"),
    @NamedQuery(name = "Reservations.findByRoomNumber", query = "SELECT r FROM Reservations r WHERE r.roomNumber = :roomNumber"),
    @NamedQuery(name = "Reservations.findByFrom", query = "SELECT r FROM Reservations r WHERE r.from = :from"),
    @NamedQuery(name = "Reservations.checkAvailability", query = "SELECT r FROM Reservations r WHERE r.roomNumber = :roomNumber"
            + " AND ((r.from >= :from AND r.from <= :to) OR (r.to >= :from AND r.to <= :to))"),
    @NamedQuery(name = "Reservations.findByTo", query = "SELECT r FROM Reservations r WHERE r.to = :to")})
public class Reservations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReservationID")
    private Integer reservationID;
    @Column(name = "RoomNumber")
    private Integer roomNumber;
    @Column(name = "FromDate")   
    private java.sql.Date from;
    @Column(name = "ToDate")    
    private java.sql.Date to;
    @Size(max = 50)
    @Column(name = "Username")
    private String username;

    public Reservations() {
    }

    public Reservations(Integer reservationID) {
        this.reservationID = reservationID;
    }

    public Integer getReservationID() {
        return reservationID;
    }

    public void setReservationID(Integer reservationID) {
        this.reservationID = reservationID;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public java.sql.Date getFrom() {
        return from;
    }

    public void setFrom(java.sql.Date from) {
        this.from = from;
    }

    public java.sql.Date getTo() {
        return to;
    }

    public void setTo(java.sql.Date to) {
        this.to = to;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationID != null ? reservationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservations)) {
            return false;
        }
        Reservations other = (Reservations) object;
        if ((this.reservationID == null && other.reservationID != null) || (this.reservationID != null && !this.reservationID.equals(other.reservationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reservations[ reservationID=" + reservationID + " ]";
    }
    
}
