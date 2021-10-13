/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.controllers;

/**
 *
 * @author unPandicornio
 */
import com.rentacubiculo.biblioteca.app.entities.Library;
import com.rentacubiculo.biblioteca.app.services.LibraryService;
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



@RestController
@RequestMapping("Library")
public class LibraryController {
    
    @Autowired
    private LibraryService service;
    
    @GetMapping("/all")
    public List<Library> findAllLibrary(){
        return service.getLibraries();
    }
    
    @PostMapping("/save")
    public ResponseEntity addLibrary(@RequestBody Library library){
        service.saveLibrary(library);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateLibrary(@RequestBody Library library){
        service.updateLibrary(library);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
 
}


