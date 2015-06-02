/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @Column(name = "From")
    @Temporal(TemporalType.TIMESTAMP)
    private Date from;
    @Column(name = "To")
    @Temporal(TemporalType.TIMESTAMP)
    private Date to;

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

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
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
