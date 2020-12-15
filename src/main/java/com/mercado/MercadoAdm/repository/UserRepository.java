package com.mercado.MercadoAdm.repository;

import com.mercado.MercadoAdm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(@Param("nome") String name);

    @Query(value = "SELECT u FROM User u WHERE u.cpf = :cpf")
    User findByCPF(@Param("cpf") String cpf);
}
