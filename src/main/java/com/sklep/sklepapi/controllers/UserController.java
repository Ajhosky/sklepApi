package com.sklep.sklepapi.controllers;

import com.sklep.sklepapi.models.User;
import com.sklep.sklepapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public List<User> showUsers(){

        return userRepository.getUsers();
    }

    @GetMapping("/{id}")
    public User showUserById(@PathVariable("id")int id){
        return userRepository.getUserById(id);
    }
    @PostMapping("/add")
    public int addUser(@RequestBody List<User> users){
        return userRepository.addUser(users);
    }

    @PutMapping("/updateput/{id}")
    public String putUser(@PathVariable int id,@RequestBody User updatedUser) {
        User oldUser = userRepository.getUserById(id);
        if(oldUser != null) {
            updatedUser.setId(oldUser.getId());
            return userRepository.putUser(updatedUser) == 1 ? "OK" : "ERROR";
        }
        return "Nie istnieje";
    }

    @PatchMapping("/updatepatch/{id}")
    public String patchUser(@PathVariable int id, @RequestBody User updatedUser){
        User oldUser = userRepository.getUserById(id);
        if(oldUser != null) {
            updatedUser.setId(oldUser.getId());
            if (updatedUser.getName() != null){
                updatedUser.setName(oldUser.getName());
            }
            if (updatedUser.getSurname() != null){
                updatedUser.setSurname(oldUser.getSurname());
            }
            if (updatedUser.getEmail() != null){
                updatedUser.setEmail(oldUser.getEmail());
            }
            if (updatedUser.getRole() != 0){
                updatedUser.setRole(oldUser.getRole());
            }
            if (updatedUser.getPassword() != null){
                updatedUser.setPassword(oldUser.getPassword());
            }
            return userRepository.patchUser(updatedUser) == 1 ? "OK" : "ERROR";
        }
        return "Nie istnieje";
    }

    @DeleteMapping("/{id}")
    public int deleteUserById(@PathVariable int id){
        return userRepository.deleteUser(id);
    }


}
