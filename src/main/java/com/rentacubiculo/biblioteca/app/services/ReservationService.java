/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.services;

/**
 *
 * @author unPandicornio
 */


import com.rentacubiculo.biblioteca.app.entities.Reservation;
import com.rentacubiculo.biblioteca.app.repositories.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository repository;
    
    //Consultar Todos los registros. GET
    public List<Reservation> getReservations(){
        return repository.findAll();
    }
    
    //Registrar  PUT
    public Reservation saveReservation(Reservation reservation){
        return repository.save(reservation);
    }
    
    //Actualizar POST
    public Reservation updateReservation(Reservation reservation){
        Reservation existingReservation = repository.findById(reservation.getIdReservation()).orElse(null);
        existingReservation.setStartDate(reservation.getStartDate());
        existingReservation.setDevolutionDate(reservation.getDevolutionDate());
        existingReservation.setLib(reservation.getLib());
        existingReservation.setClient(reservation.getClient());
        return repository.save(existingReservation);
    }
    
    //Eliminar DELETE
    public String deleteReservation(int id){
        repository.deleteById(id);
        return "Reservacion removida " + id;
    }
    
    //Busquedas por fuera del CRUD implementads en Repositories
    
    //Buscar por ID  ya viene en el repositorio
    public Reservation getReservationById(int id){
        return repository.findById(id).orElse(null);
    }

}