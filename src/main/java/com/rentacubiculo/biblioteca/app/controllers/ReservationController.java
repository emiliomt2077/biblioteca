/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.controllers;

import com.rentacubiculo.biblioteca.app.entities.Client;
import com.rentacubiculo.biblioteca.app.services.ClientService;
import com.rentacubiculo.biblioteca.app.entities.Reservation;
import com.rentacubiculo.biblioteca.app.entities.custom.CountClient;
import com.rentacubiculo.biblioteca.app.entities.custom.StatusAmount;
import com.rentacubiculo.biblioteca.app.services.ReservationService;
import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
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
    public void save (@RequestBody Reservation reservation){
        service.save(reservation);
    }
    
    /**
     *
     * @param reservation
     */
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Reservation reservation){
        service.update(reservation);
    }
    
    /**
     *
     * @param reservationId
     */
    
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.CREATED)
    public void delete(@PathVariable("id") int reservationId) {
        service.delete(reservationId);
    }
    
    
    //RETO 5

    @GetMapping("/report-status")
    public StatusAmount getReservationStatus(){
        return service.getStatusReport();
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> getCountClient(){
        return service.getTopClients();
    }

    
    /**
     * reporte por fechas
     * @param startDate
     * @param devolutionDate
     * @return
     * @throws ParseException 
     */
    @GetMapping("/report-dates/{startDate}/{devolutionDate}")
    public List<Reservation> getReportDates(@PathVariable("startDate") String startDate, @PathVariable("devolutionDate") String devolutionDate) throws ParseException{
        return service.getReportDates(startDate, devolutionDate);
    }
}