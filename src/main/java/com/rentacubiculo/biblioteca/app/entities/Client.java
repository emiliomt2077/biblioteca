/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.entities;

/**
 *
 * @author unPandicornio
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    @Column(length=45)
    private String email;
    @Column(length=45)
    private String password;
    @Column(length=250)
    private String name; 
    private int age;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "client")
    @JsonIgnoreProperties("client")
    List<Message> messages;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "client")
    @JsonIgnoreProperties("client")
    List<Reservation> reservation;
    
   
       
    //@OneToMany(cascade = CascadeType.PERSIST,mappedBy = "reservations")
    //@JsonIgnoreProperties("library")
    //List<Reservation> reservations;
    
    //@OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    //@JsonIgnoreProperties("client")
    //public List<Reservation> reservations;
}
