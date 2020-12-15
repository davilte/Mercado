package com.mercado.MercadoAdm.repository;

import com.mercado.MercadoAdm.model.Product;
import com.mercado.MercadoAdm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findByName(@Param("nome") String name);
}
