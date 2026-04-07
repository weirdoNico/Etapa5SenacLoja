package com.mycompany.etapa4_loja;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity(name="transacao")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate dataTransacao;
    private String formaDePagamento;
    private float totalTransacao;

    @ManyToOne
    private Cliente cliente;

    public Transacao() {
    }

    public Transacao(LocalDate dataTransacao, String formaDePagamento, Cliente cliente, float totalTransacao) {
        this.dataTransacao = dataTransacao;
        this.formaDePagamento = formaDePagamento;
        this.cliente = cliente;
        this.totalTransacao = totalTransacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public float getTotalTransacao() {
        return totalTransacao;
    }

    public void setTotalTransacao(float totalTransacao) {
        this.totalTransacao = totalTransacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}