/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories.crud;


import com.rentacubiculo.biblioteca.app.entities.Reservation;
import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author unPandicornio
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
    
    //JPQl
    //@Query("selesct c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)")
    //public List<Object[]> countTotalReservationByClient();
    //public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Calendar startDate, Calendar devolutionDateBefore);    
    //public List<Reservation> findAllByStatus(String status);
}