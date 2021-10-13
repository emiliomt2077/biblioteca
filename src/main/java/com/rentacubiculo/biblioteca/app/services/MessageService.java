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
import com.rentacubiculo.biblioteca.app.entities.Message;
import com.rentacubiculo.biblioteca.app.repositories.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {
    
    @Autowired
    private MessageRepository repository;
    
    //Consultar Todos los registros.
    public List<Message> getMessages(){
        return repository.findAll();
    }
    
    //Registrar 
    public Message saveMessage(Message message){
        return repository.save(message);
    }
    
    //Actualizar
    public Message updateMessage(Message message){
        Message existingMessage = repository.findById(message.getIdMessage()).orElse(null);
        existingMessage.setMessageText(message.getMessageText());
        existingMessage.setLibrary(message.getLibrary());
        existingMessage.setClient(message.getClient());
        return repository.save(existingMessage);
    }
    
    //Eliminar
    public String deleteMessage(int id){
        repository.deleteById(id);
        return "Mensaje removido " + id;
    }
}
