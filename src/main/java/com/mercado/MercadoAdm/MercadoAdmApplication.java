package com.mercado.MercadoAdm;

import com.mercado.MercadoAdm.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MercadoAdmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadoAdmApplication.class, args);

//		Product product = new Product("Arroz", 49.99);
//		Stock stock = new Stock(20);
//		System.out.println(product.getName());
	}

}
