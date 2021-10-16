/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.controllers;

import com.rentacubiculo.biblioteca.app.entities.Reservation;
import com.rentacubiculo.biblioteca.app.services.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author unPandicornio
 */



@RestController
@RequestMapping("Reservation")
public class ReservationController {
    /**
     *
     */
    @Autowired
    private ReservationService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return service.getAll();
    }
    
    /**
     *
     * @param reservation
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation){
        return service.save(reservation);
    }
    
    /**
     *
     * @param reservation
     * @return
     */
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return service.update(reservation);
    }
    
    /**
     *
     * @param reservationId
     * @return
     */
    
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.CREATED)
    public boolean delete(@PathVariable("id") int reservationId) {
        return service.delete(reservationId);
    }
    
}