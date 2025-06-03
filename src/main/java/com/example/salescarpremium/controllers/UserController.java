package com.example.salescarpremium.controllers;

import com.example.salescarpremium.dtos.UserDTO;
import com.example.salescarpremium.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<UserDTO> listUsers() {
        try {
            return this.userService.findAllService();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
    @GetMapping("/{id}")
    public UserDTO findUser(@PathVariable Long id) {
        try {
            return this.userService.findOneService(id).orElseThrow(() -> new RuntimeException("User not found"));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @PostMapping("/save")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        try {
            return this.userService.saveService(userDTO);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        try {
            this.userService.deleteService(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
} 