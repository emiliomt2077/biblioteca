/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.controllers;

import com.rentacubiculo.biblioteca.app.entities.Category;
import com.rentacubiculo.biblioteca.app.services.CategoryService;
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
@RequestMapping("Category")
public class CategoryController {
    /**
     *
     */
    @Autowired
    private CategoryService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Category> getCategories(){
        return service.getAll();
    }
    
    /**
     *
     * @param category
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save (@RequestBody Category category){
        return service.save(category);
    }
    
    /**
     *
     * @param category
     * @return
     */
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return service.update(category);
    }
    
    /**
     *
     * @param categoryId
     * @return
     */
    
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.CREATED)
    public boolean delete(@PathVariable("id") int categoryId) {
        return service.delete(categoryId);
    }
    
}