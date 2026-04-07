package com.mycompany.etapa4_loja;

import jakarta.persistence.Entity;
import java.util.List;

@Entity(name="jogoCompravel")
public class JogoCompravel extends Jogo {

    private float preco;
    private int quantidadeEstoque;

    public JogoCompravel() {
    }

    public JogoCompravel(String nome, String desenvolvedora, String classificacaoIndicativa, List<Categoria> categorias, float preco, int quantidadeEstoque) {
        super(nome, desenvolvedora, classificacaoIndicativa, categorias);
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

}