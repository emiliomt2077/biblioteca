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

import com.rentacubiculo.biblioteca.app.entities.Category;
import com.rentacubiculo.biblioteca.app.repositories.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    
    @Autowired
    private CategoryRepository repository;
    
    //Consultar Todos los registros. GET
    public List<Category> getCategories(){
        return repository.findAll();
    }
    
    //Registrar  PUT
    public Category saveCategory(Category category){
        return repository.save(category);
    }
    
    //Actualizar POST
    public Category updateCategory(Category category){
        Category existingCategory = repository.findById(category.getId()).orElse(null);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return repository.save(existingCategory);
    }
    
    //Eliminar DELETE
    public String deleteCategory(int id){
        repository.deleteById(id);
        return "Categoria removida " + id;
    }
    
    //Busquedas por fuera del CRUD implementads en Repositories
    
    //Buscar por ID  ya viene en el repositorio
    public Category getCategoryById(int id){
        return repository.findById(id).orElse(null);
    }

}
