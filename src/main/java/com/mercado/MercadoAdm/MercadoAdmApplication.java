package com.mercado.MercadoAdm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MercadoAdmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadoAdmApplication.class, args);

		Product product = new Product("Arroz", 49.99);
		Stock stock = new Stock(20);
	}

}
