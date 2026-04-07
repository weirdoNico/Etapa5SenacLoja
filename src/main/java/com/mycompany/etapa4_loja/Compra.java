package com.mycompany.etapa4_loja;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name="compra")
public class Compra extends Transacao {

    @OneToMany
    private List<JogoCompravel> jogos;

    public Compra() {
    }

    public Compra(LocalDate dataTransacao, String formaDePagamento, Cliente cliente, float totalTransacao, List<JogoCompravel> jogos) {
        super(dataTransacao, formaDePagamento, cliente, totalTransacao);
        this.jogos = jogos;
    }

    public List<JogoCompravel> getJogos() {
        return jogos;
    }

    public void setJogos(List<JogoCompravel> jogos) {
        this.jogos = jogos;
    }

}