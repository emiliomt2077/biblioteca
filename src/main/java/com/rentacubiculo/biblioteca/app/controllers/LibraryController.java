/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.controllers;

import com.rentacubiculo.biblioteca.app.entities.Library;
import com.rentacubiculo.biblioteca.app.services.LibraryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("Lib")
public class LibraryController {
    /**
     *
     */
    @Autowired
    private LibraryService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Library> getLibraries(){
        return service.getAll();
    }
    
    /**
     *
     * @param library
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save (@RequestBody Library library){
        service.save(library);
    }
    
    /**
     *
     * @param library
     */
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Library library){
         service.update(library);
    }
    
    /**
     *
     * @param libraryId
     */
    
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.CREATED)
    public void delete(@PathVariable("id") int libraryId) {
        service.delete(libraryId);
    }
    
}



