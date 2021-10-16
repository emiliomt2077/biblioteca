/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

import com.rentacubiculo.biblioteca.app.entities.Score;
import com.rentacubiculo.biblioteca.app.repositories.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author unPandicornio
 */

@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository repository;
    
    /**
     * Consultar
     * @return 
    */
    public List<Score> getAll(){
        return (List<Score>) repository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Score> getScore(int id){
        return repository.findById(id);
    }
    
    /**
     * Registrar
     * @param score
     * @return 
     */
    public Score save(Score score){
        return repository.save(score);
    }
    
    /**
     * Eliminar
     * @param score
     */
    public void delete(Score score){
        repository.delete(score);
    }
    
    
}
