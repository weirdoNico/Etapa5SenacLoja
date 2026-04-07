package com.mycompany.etapa4_loja;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name="locacao")
public class Locacao extends Transacao {

    private LocalDate dataDevolucao, dataRetorno;
    private float multa = 0;
    private boolean devolvido = true;

    @ManyToMany
    private List<JogoLocavel> jogos;

    public Locacao() {
    }

    public Locacao(LocalDate dataTransacao, String formaDePagamento, Cliente cliente, float totalTransacao, LocalDate dataDevolucao, List<JogoLocavel> jogos) {
        super(dataTransacao, formaDePagamento, cliente, totalTransacao);
        this.dataDevolucao = dataDevolucao;
        this.jogos = jogos;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(LocalDate dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public List<JogoLocavel> getJogos() {
        return jogos;
    }

    public void setJogos(List<JogoLocavel> jogos) {
        this.jogos = jogos;
    }

}