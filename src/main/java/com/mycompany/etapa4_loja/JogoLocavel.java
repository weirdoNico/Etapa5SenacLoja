package com.mycompany.etapa4_loja;

import jakarta.persistence.Entity;
import java.util.List;

@Entity(name="jogoLocavel")
public class JogoLocavel extends Jogo {

    private boolean locarStatus = true;
    private float precoLocar = 15;
    private float precoMulta;

    public JogoLocavel() {
    }

    public JogoLocavel(String nome, String desenvolvedora, String classificacaoIndicativa, List<Categoria> categorias) {
        super(nome, desenvolvedora, classificacaoIndicativa, categorias);
    }

    public boolean isLocarStatus() {
        return locarStatus;
    }

    public void setLocarStatus(boolean locarStatus) {
        this.locarStatus = locarStatus;
    }

    public float getPrecoLocar() {
        return precoLocar;
    }

    public void setPrecoLocar(float precoLocar) {
        this.precoLocar = precoLocar;
    }

    public float getPrecoMulta() {
        return precoMulta;
    }

    public void setPrecoMulta(float precoMulta) {
        this.precoMulta = precoMulta;
    }

}