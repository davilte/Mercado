package com.mercado.MercadoAdm;

public class Product extends Stock {

    private String name;
    private double price;

    public Product(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
