package com.mercado.MercadoAdm.service;

import com.mercado.MercadoAdm.model.Product;
import com.mercado.MercadoAdm.model.User;
import com.mercado.MercadoAdm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return userRepository.saveAndFlush(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getOne(Long id) {
        if (!this.userRepository.existsById(id)) {
            throw new IllegalArgumentException();
        }

        return this.userRepository.getOne(id);
    }

    @Transactional
    public void update(Long id, User user) {
        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt == null) {
            throw new RuntimeException("Produto não existe!");
        }

        User userBD = userOpt.get();
        if(userBD.getId() != null) {
            userBD.setRoleCode(userBD.getRoleCode());

            userRepository.save(userBD);
        } else {
            throw  new RuntimeException("Não é possível atualizar este usuário!");
        }
    }

    public void delete(Long id) {
        if (!this.userRepository.existsById(id)) {
            throw new IllegalArgumentException();
        }

        this.userRepository.deleteById(id);
    }
}
