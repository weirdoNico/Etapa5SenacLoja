package com.mycompany.etapa4_loja;

import jakarta.persistence.*;
import java.util.List;

@Entity(name="jogo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome, desenvolvedora;
    private String classificacaoIndicativa;

    @ManyToMany
    private List<Categoria> categorias;

    public Jogo() {
    }

    public Jogo(String nome, String desenvolvedora, String classificacaoIndicativa, List<Categoria> categorias) {
        this.nome = nome;
        this.desenvolvedora = desenvolvedora;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.categorias = categorias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

}