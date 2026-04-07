package com.mycompany.etapa4_loja;

import jakarta.persistence.Entity;

@Entity(name="cliente")
public class Cliente extends Usuario {

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String telefone, String email) {
        super(nome, cpf, telefone, email);
    }
}