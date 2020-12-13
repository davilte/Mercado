package com.mercado.MercadoAdm.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cpf;
    private String roleCode;

    public User(String name, String cpf, String role) {
        this.name = name;
        this.cpf = cpf;
        this.roleCode = role;
    }

    public User() {
    }

    // getters and setters;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
