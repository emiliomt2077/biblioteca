/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;


import com.rentacubiculo.biblioteca.app.entities.Library;
import com.rentacubiculo.biblioteca.app.repositories.crud.LibraryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author unPandicornio
 */
@Repository
public class LibraryRepository {
    
   @Autowired
    private LibraryCrudRepository repository;
    
    /**
     * Consultar
     * @return 
    */
    public List<Library> getAll(){
        return (List<Library>) repository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Library> getLibrary(int id){
        return repository.findById(id);
    }
    
    /**
     * Registrar
     * @param library
     * @return 
     */
    public Library save(Library library){
        return repository.save(library);
    }
    
    /**
     * Eliminar
     * @param library
     */
    public void delete(Library library){
        repository.delete(library);
    }
    
    
}