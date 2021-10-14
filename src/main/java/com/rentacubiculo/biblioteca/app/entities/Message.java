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
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="messages")
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;
    @Column(length=250)
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name="library_id")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Library lib;
    
    @ManyToOne
    @JoinColumn(name="id_client")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;
}

