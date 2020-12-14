package com.mercado.MercadoAdm.controller;

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

    @PostMapping("/user/save")
    public ResponseEntity<Object> registerProduct(@RequestBody User user) {
        try {
            this.userService.register(user);

            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable(name = "id", required = true) Long idUser) {
        try {
            this.userService.getOne(idUser);

            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/user")
    public List<User> findAllUsers() {
        try {
            this.userService.getAll();

            return (List<User>) ResponseEntity.status(200).build();
        } catch (Exception e) {
            return (List<User>) ResponseEntity.status(400).build();
        }
    }

    @PutMapping("user/{id}")
    public ResponseEntity<Optional<User>> updateUser(@PathVariable(name = "id", required = true) Long idUser, @RequestBody User user) {
        try {
            userService.update(idUser, user);
            return ResponseEntity.noContent().build();
        } catch(RuntimeException exception) {
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(name = "id", required = true) Long id) {
        try {
            this.userService.delete(id);

            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
}
