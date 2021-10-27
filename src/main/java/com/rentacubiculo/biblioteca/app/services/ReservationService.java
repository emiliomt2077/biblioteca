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
import com.rentacubiculo.biblioteca.app.entities.custom.CountClient;
import com.rentacubiculo.biblioteca.app.entities.custom.StatusAmount;
import com.rentacubiculo.biblioteca.app.repositories.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;
    
    //Consultar Todos los registros.
    public List<Reservation> getAll(){
        return repository.getAll();
    }
    
    
    /**
     * estado de reservaciones canceladas y completas
     * @return 
     */
    
    public HashMap <String, Integer> getReservationStatus(){
        
        Integer completed = 0;
        Integer cancelled = 0;
        
        List<Reservation> list = repository.getAll();        
        HashMap <String, Integer> status = new HashMap(); 
        
        for(Reservation param : list) {
            if ("completed".equals(param.getStatus())) {
                    completed++;
                }
            if ("cancelled".equals(param.getStatus())) {
                    cancelled++;
                }
        }       
        
        status.put("completed", completed);
        status.put("cancelled", cancelled);
        
        return status;
    }
    
    
    //Buscar registro
    public Optional<Reservation> getReservation(int reservationId) {
        return repository.getReservation(reservationId);
    }
    
    //Registrar 
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return repository.save(reservation);
        }else{
            Optional<Reservation> resultado = repository.getReservation(reservation.getIdReservation());
            if(resultado.isPresent()){
                return reservation;
            }else{
                return repository.save(reservation);
            }
        }
    }
    //Actualizar
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> resultado = repository.getReservation(reservation.getIdReservation());
            if(resultado.isPresent()){
                if(reservation.getStartDate()!=null){
                    resultado.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    resultado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getLib()!=null){
                    resultado.get().setLib(reservation.getLib());
                }
                if(reservation.getClient()!=null){
                    resultado.get().setClient(reservation.getClient());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    
    //Eliminar
    public boolean delete(int id){
        Boolean aBoolean = getReservation(id).map(reservation -> {
           repository.delete(reservation);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
    
    
    //master class
    
    public List<CountClient> getTopClients(){
        return repository.getTopClients();
    }
    
    public StatusAmount getStatusReport(){
        List<Reservation> completed=repository.getReservationsByStatus("completed");
        List<Reservation> cancelled=repository.getReservationsByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());
        
    }
    
    
    public List<Reservation> getReportDates(String startDateURL, String devolutionDateURL) throws ParseException{ 
        
        //convertir string a Calendar
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(startDateURL);
        Date dateEnd = sdf.parse(devolutionDateURL);
        Calendar startDateCalendar = Calendar.getInstance();
        Calendar devolutionDateCalendar = Calendar.getInstance();
        startDateCalendar.setTime(date);
        devolutionDateCalendar.setTime(dateEnd);
        
        if(startDateCalendar.before(devolutionDateCalendar)){
            return repository.getReservationPeriod(startDateCalendar, devolutionDateCalendar);
        }else{
            return new ArrayList<>();
        }
        
    }
}