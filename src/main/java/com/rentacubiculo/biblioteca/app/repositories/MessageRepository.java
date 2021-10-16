/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

import com.rentacubiculo.biblioteca.app.entities.Message;
import com.rentacubiculo.biblioteca.app.repositories.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author unPandicornio
 */
@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository repository;
    
    /**
     * Consultar
     * @return 
    */
    public List<Message> getAll(){
        return (List<Message>) repository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Message> getMessage(int id){
        return repository.findById(id);
    }
    
    /**
     * Registrar
     * @param message
     * @return 
     */
    public Message save(Message message){
        return repository.save(message);
    }
    
    /**
     * Eliminar
     * @param message
     */
    public void delete(Message message){
        repository.delete(message);
    }
    
    
}