package com.mercado.MercadoAdm;

public class Stock {

    private int quantity;

    public Stock(int quantity) {
        this.quantity = quantity;
    }

    public Stock() {
       super();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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
