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
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="library")
public class Library implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length=45)
    private String name;
    @Column(length=45)
    private String target;
    private Integer capacity;
    @Column(length=250)
    private String description;
    
    
    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties("libs")
    private Category category;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "lib")
    @JsonIgnoreProperties({"messages", "lib", "client"})
    List<Message> messages;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "lib")
    @JsonIgnoreProperties("reservations")
    List<Reservation> reservations;
    
}
