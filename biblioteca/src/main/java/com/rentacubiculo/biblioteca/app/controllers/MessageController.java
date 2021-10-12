/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.controllers;


import com.rentacubiculo.biblioteca.app.entities.Message;
import com.rentacubiculo.biblioteca.app.services.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author unPandicornio
 */



@RestController
@RequestMapping("Message")
public class MessageController {
    
    @Autowired
    private MessageService service;
    
    @GetMapping("/all")
    public List<Message> findAllMessage(){
        return service.getMessages();
    }
    
    @PostMapping("/save")
    public ResponseEntity addClient(@RequestBody Message message){
        service.saveMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateMessage(@RequestBody Message message){
        service.updateMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}