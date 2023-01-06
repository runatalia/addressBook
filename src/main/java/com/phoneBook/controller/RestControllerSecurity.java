package com.phoneBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")
public class RestControllerSecurity {
    
    @GetMapping("authorization")
    public String getAuthorization(){
        return "authorization";
    }
    
    @PostMapping("authorization")
    public String authorizationChek(){
        return "showAllPersonsViewForAdmin";
    }
    
}
