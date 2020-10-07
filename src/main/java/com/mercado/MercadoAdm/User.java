package com.mercado.MercadoAdm;

public class User {

    private String name;
    private int cpf;
    private String role;

    public String getName() {
        return name;
    }

    public int getCpf() {
        return cpf;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String name, int cpf, String role) {
        this.name = name;
        this.cpf = cpf;
        this.role = role;
    }
}
