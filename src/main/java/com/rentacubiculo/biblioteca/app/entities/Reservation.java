/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Calendar;
import javax.persistence.Temporal;

/**
 *
 * @author unPandicornio
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
    //@Column(length=250)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar startDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar devolutionDate;
    
    private boolean status;
    
    @ManyToOne
    @JoinColumn(name="library_id")
    @JsonIgnoreProperties({"reservations", "lib"})
    private Library lib;
    
    @ManyToOne
    @JoinColumn(name="id_client")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;
    
    private boolean score;
    
}