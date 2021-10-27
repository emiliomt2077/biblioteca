/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.entities.custom;

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
public class StatusAmount {
    private int completed;
    private int cancelled;
}
