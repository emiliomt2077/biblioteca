/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.entities.custom;

import com.rentacubiculo.biblioteca.app.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author unPandicornio
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountClient {
    private Integer total;
    private Client client;
}
