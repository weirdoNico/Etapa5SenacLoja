package com.mycompany.etapa4_loja;

import jakarta.persistence.Entity;

@Entity(name="funcionario")
public class Funcionario extends Usuario {

    private String senha;

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String telefone, String email, String senha) {
        super(nome, cpf, telefone, email);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}