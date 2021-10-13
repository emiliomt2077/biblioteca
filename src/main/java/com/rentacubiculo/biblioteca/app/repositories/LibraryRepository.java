/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

/**
 *
 * @author unPandicornio
 */
import com.rentacubiculo.biblioteca.app.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fdomoreno
 */
public interface LibraryRepository extends JpaRepository<Library,Integer> {
    // busqueda por nombre tambien en Service
    Library findByName(String name);
}

