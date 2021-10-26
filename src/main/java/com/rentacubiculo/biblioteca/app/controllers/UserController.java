/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.controllers;

import java.util.Collections;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author unPandicornio
 */

@RestController
@RequestMapping("User")
//public class UserController {
//    @GetMapping
//   public Map<String,Object> user (@AuthenticationPrincipal OAuth2User principal){
//        //return principal.getAttributes();
//        return Collections.singletonMap("login", principal.getAttribute("login"));
//    }
//}
