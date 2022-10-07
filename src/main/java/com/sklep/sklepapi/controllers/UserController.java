package com.sklep.sklepapi.controllers;

import com.sklep.sklepapi.models.User;
import com.sklep.sklepapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/")
    public String main(){
        return "Strona glownhghfghfa";

    }
    @GetMapping("/api/liczba")
    public String num() {
        return "Strona glowna";
    }
    @GetMapping("/api/users")
    public List<User> showUsers(){
        return userRepository.getUsers();

    }

}
