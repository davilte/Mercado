package com.mercado.MercadoAdm;

public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
