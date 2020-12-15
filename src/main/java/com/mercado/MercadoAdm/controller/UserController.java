package com.mercado.MercadoAdm.controller;

import com.mercado.MercadoAdm.model.Product;
import com.mercado.MercadoAdm.model.User;
import com.mercado.MercadoAdm.repository.UserRepository;
import com.mercado.MercadoAdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> registerProduct(@RequestBody User user) {
        try {
            User usr = this.userService.register(user);

            return ResponseEntity.status(201).body(usr);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(name = "id", required = true) int idUser) {
        try {
            User user = this.userService.getOne(idUser);

            return ResponseEntity.status(200).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> findAllUsers() {
        try {
            List<User> user = this.userService.getAll();

            return ResponseEntity.status(200).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("user/{id}")
    public ResponseEntity<Optional<User>> updateUser(@PathVariable(name = "id", required = true) int idUser, @RequestBody User user) {
        try {
            userService.update(idUser, user);
            return ResponseEntity.noContent().build();
        } catch(RuntimeException exception) {
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(name = "id", required = true) int id) {
        try {
            this.userService.delete(id);

            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
}
