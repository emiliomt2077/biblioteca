/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories.crud;


import com.rentacubiculo.biblioteca.app.entities.Score;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author unPandicornio
 */
public interface ScoreCrudRepository extends CrudRepository<Score,Integer> {
    
}