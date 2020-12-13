package com.mercado.MercadoAdm.repository;

import com.mercado.MercadoAdm.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaesRepository extends JpaRepository<Sales, Long> {
}
