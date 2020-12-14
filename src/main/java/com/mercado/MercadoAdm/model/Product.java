package com.mercado.MercadoAdm.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //methods
    public void fill(int n) {
        this.quantity += n;
    }
    public void buy() {
        this.quantity--;
    }
    public void delete() {
        this.quantity = 0;
    }
    public void update(int n) {
        this.quantity = n;
    }
}
