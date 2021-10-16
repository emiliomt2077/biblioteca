/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;


import com.rentacubiculo.biblioteca.app.entities.Reservation;
import com.rentacubiculo.biblioteca.app.repositories.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author unPandicornio
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository repository;
    
    /**
     * Consultar
     * @return 
    */
    public List<Reservation> getAll(){
        return (List<Reservation>) repository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Reservation> getReservation(int id){
        return repository.findById(id);
    }
    
    /**
     * Registrar
     * @param reservation
     * @return 
     */
    public Reservation save(Reservation reservation){
        return repository.save(reservation);
    }
    
    /**
     * Eliminar
     * @param reservation
     */
    public void delete(Reservation reservation){
        repository.delete(reservation);
    }
    
    
}