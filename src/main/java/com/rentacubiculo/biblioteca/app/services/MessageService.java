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
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;
    
    //Consultar Todos los registros.
    public List<Message> getAll(){
        return repository.getAll();
    }
    
    //Buscar registro
    public Optional<Message> getMessage(int messageId) {
        return repository.getMessage(messageId);
    }
    
    //Registrar 
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return repository.save(message);
        }else{
            Optional<Message> resultado = repository.getMessage(message.getIdMessage());
            if(resultado.isPresent()){
                return message;
            }else{
                return repository.save(message);
            }
        }
    }
    //Actualizar
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> resultado = repository.getMessage(message.getIdMessage());
            if(resultado.isPresent()){
                if(message.getMessageText()!=null){
                    resultado.get().setMessageText(message.getMessageText());
                }
                if(message.getLib()!=null){
                    resultado.get().setLib(message.getLib());
                }
                if(message.getClient()!=null){
                    resultado.get().setClient(message.getClient());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    
    //Eliminar
    public boolean delete(int id){
        Boolean aBoolean = getMessage(id).map(message -> {
           repository.delete(message);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
}