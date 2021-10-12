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
import com.rentacubiculo.biblioteca.app.entities.Client;
import com.rentacubiculo.biblioteca.app.repositories.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    
    //Consultar Todos los registros.
    public List<Client> getClients(){
        return repository.findAll();
    }
    
    //Registrar 
    public Client saveClient(Client client){
        return repository.save(client);
    }
    
    //Actualizar
    public Client updateClient(Client client){
        Client existingClient = repository.findById(client.getIdClient()).orElse(null);
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        existingClient.setAge(client.getAge());
        existingClient.setPassword(client.getPassword());
        return repository.save(existingClient);
    }
    
    //Eliminar
    public String deleteClient(int id){
        repository.deleteById(id);
        return "Cliente removido " + id;
    } 
}