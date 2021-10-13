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
import com.rentacubiculo.biblioteca.app.entities.Library;
import com.rentacubiculo.biblioteca.app.repositories.LibraryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    
    
    @Autowired
    private LibraryRepository repository;
    
    //Consultar Todos los registros. GET
    public List<Library> getLibraries(){
        return repository.findAll();
    }
    
    //Registrar  PUT
    public Library saveLibrary(Library library){
        return repository.save(library);
    }
    
    //Actualizar POST
    public Library updateLibrary(Library library){
        Library existingLibrary = repository.findById(library.getId()).orElse(null);
        existingLibrary.setName(library.getName());
        existingLibrary.setTarget(library.getTarget());
        existingLibrary.setCapacity(library.getCapacity());
        existingLibrary.setDescription(library.getDescription());
        existingLibrary.setCategory(library.getCategory());
        return repository.save(existingLibrary);
    }
    
    //Eliminar DELETE
    public String deleteLibrary(int id){
        repository.deleteById(id);
        return "Cubiculo removido " + id;
    }
    
    //Busquedas por fuera del CRUD implementads en Repositories
    //Busqueda por nombre
    public Library getLibraryByName(String name){
        return repository.findByName(name);
    }
    
    //Buscar por ID  ya viene en el repositorio
    public Library getLibraryById(int id){
        return repository.findById(id).orElse(null);
    }

}

